package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class GLL {
    public GLL(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GLL");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setLatitude(s[1] + " " + s[2]);
            setLongitude(s[3] + " " + s[4]);
            setUtcPos(s[5]);
            setStatus(s[6].charAt(0));
            setMode(s[7].charAt(0));
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
    private String latitude;
    private String longitude;
    private String utcPos;

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

    public String getUtcPos() {
        return utcPos;
    }

    public void setUtcPos(String utcPos) {
        this.utcPos = utcPos;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getMode() {
        return mode;
    }

    public void setMode(char mode) {
        this.mode = mode;
    }

    private char status;
    private char mode;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tLatitude: " + this.getLatitude() + "\n");
        builder.append("\tLongitude: " + this.getLongitude() + "\n");
        builder.append("\tUTCOfPosition: " + this.getUtcPos() + "\n");
        builder.append("\tStatus: " + this.getStatus() + "\n");
        builder.append("\tModeIndicator: " + this.getMode() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Latitude", this.getLatitude(), "North / South");
        ct.addRow("Longitude", this.getLongitude(), "East / West");
        ct.addRow("UTC of Position", this.getUtcPos() ,"hhmmss.ss");
        ct.addRow("Status", String.valueOf(this.getStatus()), Describer.describeCurrentData(this.getStatus()));
        ct.addRow("Mode Indicator", String.valueOf(this.getMode()), Describer.describePosMode(this.getMode()));
        ct.print();
    }
}
