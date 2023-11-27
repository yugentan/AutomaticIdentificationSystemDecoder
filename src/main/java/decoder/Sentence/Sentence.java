package decoder.Sentence;

import decoder.Message.Encapsulated.Emessage;
import decoder.Message.Parametric.Pmessage;
import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.LinkedList;
public class Sentence {
    public Sentence(){}
    public static void sentenceToMessage(ArrayList<LinkedList<Sentence>> _sentenceChainArray){
        for(LinkedList<Sentence> sentenceChain : _sentenceChainArray){
            if(sentenceChain.peek().getDelimiter() == '!'){
                Emessage eMeg = new Emessage();
                eMeg.init(sentenceChain);
                eMeg.run();
            }else{
                Pmessage pMeg = new Pmessage();
                pMeg.init(sentenceChain);
            }
        }
    }
    public boolean initializeSentence(String _sentence) {
        String[] splitSentence = _sentence.split(",");
        setDelimiter(splitSentence[0].charAt(0));  // ! or $
        if (this.getDelimiter() == '!') {
            setIsEncapsulated(true);
            setIsParametric(false);
            setTalker(splitSentence[0].substring(1,3));
            setFormat(splitSentence[0].substring(3));
            return true;
        }else if (this.getDelimiter() == '$') {
            setIsParametric(true);
            setIsEncapsulated(false);
            setTalker(splitSentence[0].substring(1,3));
            setFormat(splitSentence[0].substring(3));
            return true;
        } else {
            logger.warn("Sentence Structure Error: " + _sentence);
            System.out.println("Delimiter Invalid: Only accept starting character ! or $ \n" +
                                "Sentence invalid: " + _sentence);
            return false;
        }
    }
    public void serializeSentence(String _sentence) {
        String[] splitSentence = _sentence.split(",");
        if (this.getIsEncapsulated()) {
            try{
                setSentenceLength(Integer.parseInt(splitSentence[1]));
            }catch(Exception e){
                setSentenceLength(1);
            }
            //SLOT 3; a[2] Iteration Count
            try{
                setSentenceNumber(Integer.parseInt(splitSentence[2]));
            }catch(Exception e){
                setSentenceNumber(0);
            }
            //SLOT 4; a[3] Sentence ID
            try{
                setSentenceIdentifier(Integer.parseInt(splitSentence[3]));
            }catch(Exception e){
                setSentenceIdentifier(0);
            }
        }
        if (this.getIsParametric()) {
            //do something
        }
    }
    public void verifySentenceSequence(Sentence _s) {
        if(this.getSentenceLength() == _s.getSentenceLength() && this.getSentenceIdentifier() == _s.getSentenceIdentifier()){
            if (this.getSentenceNumber() == (_s.getSentenceNumber() - 1)) {
                _s.setIsNext(true);
            } else {
                _s.setIsNext(false);
            }
        } else {
            _s.setIsNext(false);
        }
    }

    /** If checksum of sentence number 1 is messed up and 2 is assigned or more this clears the linked list*/
    public static void sanitizeLinkListArray(ArrayList<LinkedList<Sentence>> _sentenceChainArray){
        for(int i = 0; i < _sentenceChainArray.size(); i++){
            if(_sentenceChainArray.get(i).peek().getSentenceNumber() != 1 && _sentenceChainArray.get(i).peek().getDelimiter() != '$'){
                logger.warn("Sentence Sequence Error: " + _sentenceChainArray.get(i).peek().getSentenceString());
                _sentenceChainArray.remove(i);
            }
        }
    }
    public static boolean verifyChecksum(String _s) {
        String a = getStringChecksum(getChecksum(_s));
        String b;
        try{
            b = String.valueOf(_s.toCharArray()[_s.length() - 2]) +  String.valueOf(_s.toCharArray()[_s.length() - 1]);
        } catch (Exception e) {
            b = "0";
            System.out.println("CHECKSUM ERROR");
        }
        if (a.equals(b)) {
            return true;
        } else {
            logger.warn("Checksum invalid: " + _s);
            System.out.println("Checksum invalid: " + _s);
            return false;
        }
    }
    public static int getChecksum(String _sentence) {
        int checksum = 0;
        for (int i = 1; i < _sentence.length(); i++) {
            char c = _sentence.charAt(i);
            if (c == '!' || c == '$') {
                System.out.println("Start Character Found before Checksum");
                break;
            }
            if (c == '*') {
                break;
            }
            checksum ^= c;
        }
        return checksum;
    }
    public static String getStringChecksum(int _checksum) {
        String strChecksum = Integer.toString(_checksum, 16).toUpperCase();
        if (strChecksum.length() < 2) {
            strChecksum = "0" + strChecksum;
        }
        return strChecksum;
    }
    /**********CHECKSUM CALCULATION*********************/

    private String sentenceString;
    private String talker;
    private char delimiter;
    private String formatter;
    private int sentenceLength;
    private int sentenceNumber;
    private int sentenceIdentifier;
    private boolean isParametric;
    private boolean isEncapsulated;
    private boolean isNext;

    /** Getters */
    public  String getSentenceString(){
        return this.sentenceString;
    }
    public char getDelimiter(){
        return this.delimiter;
    }
    public String getTalker(){
        return this.talker;
    }
    public String getFormatter(){
        return this.formatter;
    }
    public static String getCheckSumString(String s){
        return getStringChecksum(getChecksum(s));
    }
    public int getSentenceLength(){
        return this.sentenceLength;
    }
    public int getSentenceNumber(){
        return this.sentenceNumber;
    }
    public int getSentenceIdentifier(){
        return this.sentenceIdentifier;
    }
    public boolean getIsEncapsulated(){
        return this.isEncapsulated;
    }
    public boolean getIsParametric(){
        return this.isParametric;
    }
    public boolean getIsNext(){
        return this.isNext;
    }
    /** Setters*/
    public void setSentenceString(String _s){
        this.sentenceString = _s;
    }
    public void setDelimiter(char _c){
        this.delimiter = _c;
    }
    public void setTalker(String _s){
        this.talker = _s;
    }
    public void setFormat(String _s){
        this.formatter = _s;
    }
    public void setSentenceLength(int _i){
        // 1-9
        this.sentenceLength = _i;
    }
    public void setSentenceNumber(int _i){
        this.sentenceNumber = _i;
    }
    public void setSentenceIdentifier(int _i){
        this.sentenceIdentifier = _i;
    }
    public void setIsParametric(boolean _b){
        this.isParametric = _b;
    }
    public void setIsEncapsulated(boolean _b){
        this.isEncapsulated = _b;
    }
    public void setIsNext(boolean _b){
        this.isNext = _b;
    }
    private static Logger logger = LogManager.getLogger(Sentence.class.getName());

}
