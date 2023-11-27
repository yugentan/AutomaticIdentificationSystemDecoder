package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class LRF {
    public LRF(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: LRF");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setSequenceNumber(s[1]);
            setRequesterMMSI(s[2]);
            setRequesterName(s[3]);
            setFunctionRequest(s[4]);
            setReplyStatus(s[5]);
        } catch (Exception e) {
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
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

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getRequesterMMSI() {
        return requesterMMSI;
    }

    public void setRequesterMMSI(String requesterMMSI) {
        this.requesterMMSI = requesterMMSI;
    }

    public String getFunctionRequest() {
        return functionRequest;
    }

    public void setFunctionRequest(String functionRequest) {
        this.functionRequest = functionRequest;
    }

    public String getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(String replyStatus) {
        this.replyStatus = replyStatus;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    private String sequenceNumber;
    private String requesterMMSI;
    private String functionRequest;
    private String replyStatus;
    private String requesterName;
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
        builder.append("\tSequenceNumber: " + this.getSequenceNumber()+ "\n");
        builder.append("\tRequesterMMSI: " + this.getRequesterMMSI()+ "\n");
        builder.append("\tRequesterName: " + this.getRequesterName() + "\n");
        builder.append("\tFunctionRequest: " + this.getFunctionRequest() + "\n");
        builder.append("\tFunctionReplyStatus: " + this.getReplyStatus() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Sequence Number", this.getSequenceNumber(), "");
        ct.addRow("MMSI of requestor", this.getRequesterMMSI() ,"");
        ct.addRow("Name of requestor", this.getRequesterName() ,"");
        ct.addRow("Function Request", this.getFunctionRequest() , Describer.describeLR1FunctionRequest(this.getFunctionRequest()));
        ct.addRow("Function Reply Status", this.getReplyStatus() ,"");
        ct.print();
    }
}
