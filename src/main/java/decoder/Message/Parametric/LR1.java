package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class LR1 {
    public LR1(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: LR1");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setSequenceNumber(s[1]);
            setMMSIresponder(s[2]);
            setMMSIrequestor(s[3]);
            setShipName(s[4]);
            setCallSign(s[5]);
            setImoNum(s[6].split("\\*")[0]);
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

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getMMSIresponder() {
        return MMSIresponder;
    }

    public void setMMSIresponder(String MMSIresponder) {
        this.MMSIresponder = MMSIresponder;
    }

    public String getMMSIrequestor() {
        return MMSIrequestor;
    }

    public void setMMSIrequestor(String MMSIrequestor) {
        this.MMSIrequestor = MMSIrequestor;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getImoNum() {
        return imoNum;
    }

    public void setImoNum(String imoNum) {
        this.imoNum = imoNum;
    }
    private String talker;
    private String format;
    private String sequenceNumber;
    private String MMSIresponder;
    private String MMSIrequestor;
    private String shipName;
    private String callSign;
    private String imoNum;

    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tSequenceNumber: " + this.getSequenceNumber() + "\n");
        builder.append("\tMMSIResponder: "+ this.getMMSIresponder() + "\n");
        builder.append("\tMMSIRequestor: " + this.getMMSIrequestor() +"\n");
        builder.append("\tShipName: " + this.getShipName() +"\n");
        builder.append("\tCallSign: " + this.getCallSign() +"\n");
        builder.append("\tIMONumber: " + this.getImoNum() +"\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Sequence Number", this.getSequenceNumber(),"");
        ct.addRow("MMSI Responder", this.getMMSIresponder(),"");
        ct.addRow("MMSI Requestor", this.getMMSIrequestor(),"");
        ct.addRow("Ship's Name", this.getShipName(),"");
        ct.addRow("Call Sign", this.getCallSign(),"");
        ct.addRow("IMO Number", this.getImoNum(),"");
        ct.print();
    }
}
