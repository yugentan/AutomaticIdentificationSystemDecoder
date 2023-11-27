package decoder.Receiver;

import decoder.FileReader.FileReader;
import decoder.Sentence.Sentence;
import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Receiver {
    public Receiver(){};
    public void init(){
        generateQueue();
        readQueue();
    }
    public void handleStream(String _inputString){
        Sentence s =  new Sentence();
        if(Sentence.verifyChecksum(_inputString) && s.initializeSentence(_inputString)){
            s.serializeSentence(_inputString);
            s.setSentenceString(_inputString);
        }
    }
    public void readQueue() {
        Sentence.sanitizeLinkListArray(sentenceQueue);
        Sentence.sentenceToMessage(sentenceQueue);
    }
    private void generateQueue(){
        String data;
        String[] dataArray;
        ArrayList<Sentence> checksumValidSentences = new ArrayList<Sentence>();
        try{
            data = FileReader.read("data/incoming.txt");
            dataArray = data.split(System.lineSeparator());
            /** Validates strings from input file, coverts into sentences then add into the valid checksum array*/
            for(String i : dataArray){
                Sentence s = new Sentence();
               if(Sentence.verifyChecksum(i) && s.initializeSentence(i)) {
                    s.serializeSentence(i);
                    s.setSentenceString(i);
                    checksumValidSentences.add(s);
               }
            }
            cleanSentence(checksumValidSentences);
            convertSequenceToQueue(checksumValidSentences);
        }catch (Exception e){
            System.out.println("Receiver.generateQueue Error: Fail to read file...");
            logger.error("File error, fail to read file");
        }
    }

    /** Cleaning for sentences that are follow up to the prev, variable isNext will be true */
    private void cleanSentence(ArrayList<Sentence> validSentences){
        for(int i = 0; i < validSentences.size(); i++){
            Sentence cur = validSentences.get(i);
            Sentence next = validSentences.get(i+1 < validSentences.size() ? i+1 : i);
            if(!cur.equals(next)){
                cur.verifySentenceSequence(next);
            }
        }
    }

    /** Generate linked list to sentence queue to determine order of sentence
     * If and only if {F->T}->T->T->T ...
     * If F F creates singly linked list by clearing the last instance
     **/
    private void convertSequenceToQueue(ArrayList<Sentence> validSentences){
        LinkedList<Sentence> sequence = new LinkedList<Sentence>();
        for(int i = 0; i < validSentences.size(); i++){
            if(!validSentences.get(i).getIsNext() && sequence.size() != 0){
                //JAVA PASSES BY REFERENCE!!!!!
                LinkedList<Sentence> copySequence = (LinkedList<Sentence>)sequence.clone();
                this.sentenceQueue.add(copySequence);
                sequence.clear();
            }
            sequence.add(validSentences.get(i));
        }
        /** Add last sequence*/
        if(sequence.size() != 0){
            LinkedList<Sentence> copySequence = (LinkedList<Sentence>)sequence.clone();
            this.sentenceQueue.add(copySequence);
            sequence.clear();
        }

    }
    private ArrayList<LinkedList<Sentence>> sentenceQueue = new ArrayList<LinkedList<Sentence>>();
    private static Logger logger = LogManager.getLogger(Receiver.class.getName());

}
