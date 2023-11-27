package decoder.Message.Encapsulated;

import decoder.Binary.Binary;
import decoder.Binary.HashTables;
import decoder.Message.Types.*;
import decoder.Sentence.Sentence;

import java.util.LinkedList;
import java.util.Map;

public class Emessage {
    public Emessage(){};
    public void init(LinkedList <Sentence> _sentenceChain){
        StringBuilder builder = new StringBuilder();
        for(Sentence s : _sentenceChain){
            String[] splitSentence = s.getSentenceString().split(",");
            setChannel(splitSentence[4]);
            builder.append(splitSentence[5]);
        }
        setPayload(builder.toString());
    }
    public void run(){
        setHashMap();
        setBitmap(getPayload());
        this.assignCommonField();
        this.handleMessageType(this);
    }

    /** Getters*/
    public int getMsgId(){
        return msgId;
    }
    public int getRepeater(){
        return repeater;
    }
    public int getMMSI(){
        return mmsi;
    }
    public String getChannel(){
        return channel;
    }
    public String getPayload(){
        return payload;
    }
    public String getBitmap(){ return this.bitmap; }
    /** Setters*/
    public void setMsgId(int mi){
        this.msgId = mi;
    }
    public void setRepeater(int r){
        this.repeater = r;
    }
    public void setMMSI(int m){
        this.mmsi = m;
    }
    public void setChannel(String s){
        this.channel = s;
    }

    public void setPayload(String s){
        this.payload = s;
    }
    private void handleMessageType(Emessage e){
        if(this.getMsgId() == 1 || this.getMsgId() == 2 || this.getMsgId() == 3){
            Message123 m = new Message123();
            m.run(e);
            m.json();
            m.table();
        }else if(this.getMsgId() == 5){
            Message5 m = new Message5();
            m.run(e);
            m.json();
            m.table();
        } else if (this.getMsgId() == 6) {
            Message6 m = new Message6();
            m.run(e);
            m.json();
            m.table();
        } else if(this.getMsgId() == 9){
            Message9 m = new Message9();
            m.run(e);
            m.json();
            m.toTable();
        }else if (this.getMsgId() == 18){
            Message18 m = new Message18();
            m.run(e);
            m.json();
            m.table();
        } else if (this.getMsgId() == 19) {
            Message19 m = new Message19();
            m.run(e);
            m.json();
            m.table();
        }
    }
    /** Hashmap initialise */
    private void setHashMap(){
        bitsToStringValue = HashTables.binaryToStringTable();
    }
    /** Initialise bitmap */
    private void setBitmap(String payload){
        char[] itrStr = payload.toCharArray();
        //for initialising bitmap
        for(char c : itrStr){
            bitmap += bitsToStringValue.get(Character.toString(c));
        }
    }
    /** Assign common fields from bitmap*/
    private void assignCommonField(){
        this.assignMessageID();
        this.assignRepeater();
        this.assignMMSI();
    }
    private void assignMessageID(){
        String messageID = "";
        for(int i = 0; i < msgIDBitCount; i++){
            messageID += bitmap.toCharArray()[i+msgIDPtr];
        }
        setMsgId(Binary.convertToDec(messageID));
    }
    private void assignMMSI(){
        String mmsi = "";
        for(int i = 0; i < mmsiCount; i++){
            mmsi += bitmap.toCharArray()[i + mmsiPtr];
        }
        setMMSI(Binary.convertToDec(mmsi));
    }
    private void assignRepeater(){
        String repeater = "";
        for(int i = 0; i < repIndicatorBitCount; i++){
            repeater += bitmap.toCharArray()[i + repIndicatorPtr];
        }
        setRepeater(Binary.convertToDec(repeater));
    }
    private int mmsi;       									//30 bit	9 unique id of ship
    private int msgId;											//6 bit		Message ID for encaps
    private int repeater;										//2 bit
    final int msgIDPtr = 0, msgIDBitCount = 6;
    final int repIndicatorPtr = 6, repIndicatorBitCount = 2;
    final int mmsiPtr = 8, mmsiCount = 30;
    private String channel;
    private String payload;
    protected static Map<String, String> bitsToStringValue;
    private String bitmap = "";
}

// from data file
// set mmsi
// encrypt
// get mmsi
// encrypt in bin => convert to ascii