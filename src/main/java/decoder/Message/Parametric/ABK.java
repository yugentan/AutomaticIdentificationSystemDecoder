package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class ABK {
    public ABK(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: ABK");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setAddressedMMSI(Integer.parseInt(s[1]));
            setChannel(s[2].charAt(0));
            setMessageID(s[3]);
            setSequenceNumber(Integer.parseInt(s[4]));
            setTypeOfAck(Integer.parseInt(s[5].split("\\*")[0]));
        }catch (Exception e){
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }
    public int getAddressedMMSI() {
        return addressedMMSI;
    }
    public void setAddressedMMSI(int addressedMMSI) {
        this.addressedMMSI = addressedMMSI;
    }
    public char getChannel() {
        return channel;
    }
    public void setChannel(char channel) {
        this.channel = channel;
    }
    public String getMessageID() {
        return messageID;
    }
    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
    public int getSequenceNumber() {
        return sequenceNumber;
    }
    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    public int getTypeOfAck() {
        return typeOfAck;
    }
    public void setTypeOfAck(int typeOfAck) {
        this.typeOfAck = typeOfAck;
    }
    private int addressedMMSI;
    private char channel;
    private String messageID;
    private int sequenceNumber;
    private int typeOfAck;
    public String getTalker() {
        return talker;
    }

    public void setTalker(String talker) {
        this.talker = talker;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    private String talker;
    private String format;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tMMSI of addressed AIS unit: " + this.getAddressedMMSI() + "\n");
        builder.append("\tChannel: " + this.getChannel() + "\n");
        builder.append("\tMessage ID: " + this.getMessageID() + "\n");
        builder.append("\tMessage Sequence Number: " + this.getSequenceNumber() + "\n");
        builder.append("\tAcknowledgement Type: " + this.getTypeOfAck() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("MMSI of addressed AIS unit", String.valueOf(this.getAddressedMMSI()), "");
        ct.addRow("Channel", String.valueOf(this.getChannel()), "");
        ct.addRow("Message ID", String.valueOf(this.getMessageID()), "");
        ct.addRow("Message Sequence Number", String.valueOf(this.getSequenceNumber()),"");
        ct.addRow("Acknowledgement Type", String.valueOf(this.getTypeOfAck()), Describer.describeAck(this.getTypeOfAck()));
        ct.print();
    }
}
