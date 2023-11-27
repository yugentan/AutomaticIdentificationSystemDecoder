package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class LRI {
    public LRI(){};
    public void table(){
        try {
            this.toTable();

        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: LRI");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setSequenceNumber(s[1]);
            setControlFlag(s[2]);
            setMMSIrequestor(s[3]);
            setMMSIdestination(s[4]);
            setLatitudeN(s[5] + " " + s[6]);
            setLongitudeN(s[7] + " " + s[8]);
            setLatitudeS(s[9] + " " + s[10]);
            setLongitudeS(s[11] + " " + s[12].split("\\*")[0]);
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

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getControlFlag() {
        return controlFlag;
    }

    public void setControlFlag(String controlFlag) {
        this.controlFlag = controlFlag;
    }

    public String getMMSIrequestor() {
        return MMSIrequestor;
    }

    public void setMMSIrequestor(String MMSIrequestor) {
        this.MMSIrequestor = MMSIrequestor;
    }

    public String getMMSIdestination() {
        return MMSIdestination;
    }

    public void setMMSIdestination(String MMSIdestination) {
        this.MMSIdestination = MMSIdestination;
    }

    public String getLatitudeN() {
        return latitudeN;
    }

    public void setLatitudeN(String latitudeN) {
        this.latitudeN = latitudeN;
    }

    public String getLatitudeS() {
        return latitudeS;
    }

    public void setLatitudeS(String latitudeS) {
        this.latitudeS = latitudeS;
    }

    public String getLongitudeN() {
        return longitudeN;
    }

    public void setLongitudeN(String longitudeN) {
        this.longitudeN = longitudeN;
    }

    public String getLongitudeS() {
        return longitudeS;
    }

    public void setLongitudeS(String longitudeS) {
        this.longitudeS = longitudeS;
    }

    private String sequenceNumber;
    private String controlFlag;
    private String MMSIrequestor;
    private String MMSIdestination;
    private String latitudeN;
    private String latitudeS;
    private String longitudeN;
    private String longitudeS;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tSequenceNumber: " + this.getSequenceNumber() + "\n");
        builder.append("\tControlFlag: " + this.getControlFlag() + "\n");
        builder.append("\tMMSIRequestor: " + this.getMMSIrequestor() + "\n");
        builder.append("\tMMSIDestination: " + this.getMMSIdestination() + "\n");
        builder.append("\tLatitudeNE: " + this.getLatitudeN() + "\n");
        builder.append("\tLongitudeNE: " + this.getLongitudeN() + "\n");
        builder.append("\tLatitudeSW: " + this.getLatitudeS()+ "\n");
        builder.append("\tLongitudeSW: " + this.getLongitudeS() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Sequence Number" , this.getSequenceNumber(), "");
        ct.addRow("Control Flag", this.getControlFlag(),"");
        ct.addRow("MMSI of requestor", this.getMMSIrequestor(),"");
        ct.addRow("MMSI of destination", this.getMMSIdestination(),"");
        ct.addRow("Latitude", this.getLatitudeN(),"north-east coordinate");
        ct.addRow("Longitude", this.getLongitudeN(),"north-east coordinate");
        ct.addRow("Latitude", this.getLatitudeS(),"south-west coordinate");
        ct.addRow("Longitude", this.getLongitudeS(),"south-west coordinate");
        ct.print();
    }
}
