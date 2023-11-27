package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class LR3 {
    public LR3(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: LR3");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setSequenceNumber(s[1]);
            setMMSIresponder(s[2]);
            setVoyageDestination(s[3]);
            setEtaDate(s[4]);
            setEtaTime(s[5]);
            setDraught(s[6]);
            setShipCargo(s[7]);
            setShipLength(s[8]);
            setShipBreath(s[9]);
            setShipType(s[10]);
            setShipPersons(s[11].split("\\*")[0]);
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
    private String talker;
    private String format;
    private String sequenceNumber;
    private String MMSIresponder;
    private String voyageDestination;
    private String etaDate;
    private String etaTime;
    private String draught;
    private String shipCargo;
    private String shipLength;

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

    public String getVoyageDestination() {
        return voyageDestination;
    }

    public void setVoyageDestination(String voyageDestination) {
        this.voyageDestination = voyageDestination;
    }

    public String getEtaDate() {
        return etaDate;
    }

    public void setEtaDate(String etaDate) {
        this.etaDate = etaDate;
    }

    public String getEtaTime() {
        return etaTime;
    }

    public void setEtaTime(String etaTime) {
        this.etaTime = etaTime;
    }

    public String getDraught() {
        return draught;
    }

    public void setDraught(String draught) {
        this.draught = draught;
    }

    public String getShipCargo() {
        return shipCargo;
    }

    public void setShipCargo(String shipCargo) {
        this.shipCargo = shipCargo;
    }

    public String getShipLength() {
        return shipLength;
    }

    public void setShipLength(String shipLength) {
        this.shipLength = shipLength;
    }

    public String getShipBreath() {
        return shipBreath;
    }

    public void setShipBreath(String shipBreath) {
        this.shipBreath = shipBreath;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public String getShipPersons() {
        return shipPersons;
    }

    public void setShipPersons(String shipPersons) {
        this.shipPersons = shipPersons;
    }

    private String shipBreath;
    private String shipType;
    private String shipPersons;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tSequenceNumber: " + this.getSequenceNumber() + "\n");
        builder.append("\tMMSIResponder: " + this.getMMSIresponder() + "\n");
        builder.append("\tVoyageDestination: " + this.getVoyageDestination() + "\n");
        builder.append("\tETADate(ddmmyy): " + this.getEtaDate()+ "\n");
        builder.append("\tETATime(hhmmss.ss): " + this.getEtaTime() + "\n");
        builder.append("\tDraught: " + this.getDraught() + "\n");
        builder.append("\tShip/Cargo: " + this.getShipCargo() + "\n");
        builder.append("\tShipLength: " + this.getShipLength() + "\n");
        builder.append("\tShipBreadth: " + this.getShipBreath() + "\n");
        builder.append("\tShipType: " + this.getShipType() + "\n");
        builder.append("\tPersons: " + this.getShipPersons() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Sequence Number", this.getSequenceNumber(),"");
        ct.addRow("MMSI Responder", this.getMMSIresponder(),"");
        ct.addRow("Voyage Destination", this.getVoyageDestination(),"");
        ct.addRow("ETA Date", this.getEtaDate(),"ddmmyy");
        ct.addRow("ETA Time", this.getEtaTime(),"hhmmss.ss");
        ct.addRow("Draught", this.getDraught(),"");
        ct.addRow("Ship/Cargo", this.getShipCargo(),"");
        ct.addRow("Ship Length", this.getShipLength(),"");
        ct.addRow("Ship Breadth", this.getShipBreath(),"");
        ct.addRow("Ship Type", this.getShipType(),"");
        ct.addRow("Persons", this.getShipPersons(),"");
        ct.print();
    }
}
