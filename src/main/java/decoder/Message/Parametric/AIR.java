package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class AIR {
    public AIR(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: AIR");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setInterrogatedMMSI1(Integer.parseInt(s[1]));
            setMessageID1(s[2]);
            setMessageSubSection1(s[3]);
            setNumbMessageRequest1(s[4]);
            setMessageSubSection2(s[5]);
            setInterrogateMMSI2(Integer.parseInt(s[6]));
            setNumbRequest2(s[7]);
            setMessageSubSection3(s[8].split("\\*")[0]);
        }catch (Exception e){
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }
    public int getInterrogatedMMSI1() {
        return interrogatedMMSI1;
    }

    public void setInterrogatedMMSI1(int interrogatedMMSI1) {
        this.interrogatedMMSI1 = interrogatedMMSI1;
    }

    public String getMessageID1() {
        return messageID1;
    }

    public void setMessageID1(String messageID1) {
        this.messageID1 = messageID1;
    }

    public String getMessageSubSection1() {
        return messageSubSection1;
    }

    public void setMessageSubSection1(String messageSubSection1) {
        this.messageSubSection1 = messageSubSection1;
    }

    public String getNumbMessageRequest1() {
        return numbMessageRequest1;
    }

    public void setNumbMessageRequest1(String numbMessageRequest1) {
        this.numbMessageRequest1 = numbMessageRequest1;
    }

    public String getMessageSubSection2() {
        return messageSubSection2;
    }

    public void setMessageSubSection2(String messageSubSection2) {
        this.messageSubSection2 = messageSubSection2;
    }

    public int getInterrogateMMSI2() {
        return interrogateMMSI2;
    }

    public void setInterrogateMMSI2(int interrogateMMSI2) {
        this.interrogateMMSI2 = interrogateMMSI2;
    }

    public String getNumbRequest2() {
        return numbRequest2;
    }

    public void setNumbRequest2(String numbRequest2) {
        this.numbRequest2 = numbRequest2;
    }

    public String getMessageSubSection3() {
        return messageSubSection3;
    }

    public void setMessageSubSection3(String messageSubSection3) {
        this.messageSubSection3 = messageSubSection3;
    }
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

    private int interrogatedMMSI1;
    private String messageID1;
    private String messageSubSection1;
    private String numbMessageRequest1;
    private String messageSubSection2;
    private int interrogateMMSI2;
    private String numbRequest2;
    private String messageSubSection3;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tMMSIOfInterrogatedStation1: " + this.getInterrogatedMMSI1() + "\n");
        builder.append("\tMessageRequestFromStation1: " + this.getMessageID1() + "\n");
        builder.append("\tMessageSubSection: " + this.getMessageSubSection1() + "\n");
        builder.append("\tNumberOfSecondMessageRequestFromStation1: " + this.getNumbMessageRequest1() + "\n");
        builder.append("\tMessageSubSection: " + this.getMessageSubSection2() + "\n");
        builder.append("\tMMSIOfInterrogatedStation2: " + this.getInterrogateMMSI2() + "\n");
        builder.append("\tNumberOfMessageRequestFromStation2: " + this.getNumbRequest2() + "\n");
        builder.append("\tMessageSubSection: " + this.getMessageSubSection3() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("MMSI of interrogated station 1", String.valueOf(this.getInterrogatedMMSI1()) ,"");
        ct.addRow("ITU-R M.1371 message requested from station 1", this.getMessageID1() ,"");
        ct.addRow("Message sub-section", this.getMessageSubSection1() ,"");
        ct.addRow("Number of second message requested from station 1", this.getNumbMessageRequest1() ,"");
        ct.addRow("Message sub-section", this.getMessageSubSection2() ,"");
        ct.addRow("MMSI of interrogated station 2",String.valueOf(this.getInterrogateMMSI2()) ,"");
        ct.addRow("Number of message requested from station 2",this.getNumbRequest2(),"");
        ct.addRow("Message sub-section", this.getMessageSubSection3() ,"");
        ct.print();
    }
}
