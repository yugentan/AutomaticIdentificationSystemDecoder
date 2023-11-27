package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class LR2 {
    public LR2(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: LR2");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setSequenceNumber(s[1]);
            setMMSIresponder(s[2]);
            setDate(s[3]);
            setUtcPos(s[4]);
            setLatitude(s[5] + " " + s[6]);
            setLongitude(s[7] + " " + s[8]);
            setCog(s[9] + " " + s[10]);
            setSog(s[11] + " " + s[12]);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUtcPos() {
        return utcPos;
    }

    public void setUtcPos(String utcPos) {
        this.utcPos = utcPos;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCog() {
        return cog;
    }

    public void setCog(String cog) {
        this.cog = cog;
    }

    public String getSog() {
        return sog;
    }

    public void setSog(String sog) {
        this.sog = sog;
    }

    private String MMSIresponder;
    private String date;
    private String utcPos;
    private String latitude;
    private String longitude;
    private String cog;
    private String sog;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tSequenceNumber: " + this.getSequenceNumber() + "\n");
        builder.append("\tMMSIResponder: " + this.getMMSIresponder() + "\n");
        builder.append("\tDate(ddmmyyyy): " + this.getDate() + "\n");
        builder.append("\tUTCPosition(hhmmss.ss): " + this.getUtcPos() + "\n");
        builder.append("\tLatitude: " + this.getLatitude() + "\n");
        builder.append("\tLongitude: " + this.getLongitude() + "\n");
        builder.append("\tCourseOverGround: " + this.getCog() + "\n");
        builder.append("\tSpeedOverGround: " + this.getSog() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Sequence Number", this.getSequenceNumber() ,"");
        ct.addRow("MMSI of responder", this.getMMSIresponder(),"");
        ct.addRow("Date", this.getDate(),"ddmmyyyy");
        ct.addRow("UTC of Position", this.getUtcPos(),"hhmmss.ss");
        ct.addRow("Latitude", this.getLatitude(), "North / South");
        ct.addRow("Longitude", this.getLongitude(), "East / West");
        ct.addRow("Course over ground", this.getCog(), "degrees True");
        ct.addRow("Speed over ground", this.getSog(), "Knots");
        ct.print();
    }
}
