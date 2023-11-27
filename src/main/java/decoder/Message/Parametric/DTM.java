package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class DTM {
    public DTM(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: DTM");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setLocalDatumCode(s[1]);
            setLocalDatumSubCode(s[2]);
            setLatitudeOffset(s[3] + " " + s[4]);
            setLongitudeOffset(s[5] + " " + s[6]);
            setAltitudeOffset(s[7]);
            setDatumName(s[8].split("\\*")[0]);
        }catch (Exception e){
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

    public String getLocalDatumCode() {
        return localDatumCode;
    }

    public void setLocalDatumCode(String localDatumCode) {
        this.localDatumCode = localDatumCode;
    }

    public String getLocalDatumSubCode() {
        return localDatumSubCode;
    }

    public void setLocalDatumSubCode(String localDatumSubCode) {
        this.localDatumSubCode = localDatumSubCode;
    }

    public String getLatitudeOffset() {
        return latitudeOffset;
    }

    public void setLatitudeOffset(String latitudeOffset) {
        this.latitudeOffset = latitudeOffset;
    }

    public String getLongitudeOffset() {
        return longitudeOffset;
    }

    public void setLongitudeOffset(String longitudeOffset) {
        this.longitudeOffset = longitudeOffset;
    }

    public String getAltitudeOffset() {
        return altitudeOffset;
    }

    public void setAltitudeOffset(String altitudeOffset) {
        this.altitudeOffset = altitudeOffset;
    }

    public String getDatumName() {
        return datumName;
    }

    public void setDatumName(String datumName) {
        this.datumName = datumName;
    }

    private String localDatumCode;
    private String localDatumSubCode;
    private String latitudeOffset;
    private String longitudeOffset;
    private String altitudeOffset;
    private String datumName;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tLocalDatumCode: " + this.getLocalDatumCode() + "\n");
        builder.append("\tLocalDatumSubdivisionCode: " + this.getLocalDatumSubCode() + "\n");
        builder.append("\tLatitudeOffSet: " + this.getLatitudeOffset()  + "\n");
        builder.append("\tLongitudeOffset: " + this.getLongitudeOffset() + "\n");
        builder.append("\tAltitudeOffset: " + this.getAltitudeOffset() + "\n");
        builder.append("\tReferenceDatumCode: " + this.getDatumName() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Local Datum Code" ,this.getLocalDatumCode() ,"");
        ct.addRow("Local Datum Subdivision Code" ,this.getLocalDatumSubCode() ,"");
        ct.addRow("Latitude Offset" , this.getLatitudeOffset() ,"Minutes N/S");
        ct.addRow("Longitude Offset" , this.getLongitudeOffset() ,"Minutes E/W");
        ct.addRow("Altitude Offset" , this.getAltitudeOffset(),"");
        ct.addRow("Reference Datum Code" , this.getDatumName() ,"");
        ct.print();
    }
}
