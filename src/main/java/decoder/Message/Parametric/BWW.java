package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class BWW {
    public BWW(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: BWW");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setBearingT(s[1] + " " + s[2]);
            setBearingM(s[3] + " " + s[4]);
            setToWaypoint(s[5]);
            setFromWaypoint(s[6].split("\\*")[0]);
        }catch (Exception e){
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }

    public String getBearingT() {
        return bearingT;
    }

    public void setBearingT(String bearingT) {
        this.bearingT = bearingT;
    }

    public String getBearingM() {
        return bearingM;
    }

    public void setBearingM(String bearingM) {
        this.bearingM = bearingM;
    }

    public String getToWaypoint() {
        return toWaypoint;
    }

    public void setToWaypoint(String toWaypoint) {
        this.toWaypoint = toWaypoint;
    }

    public String getFromWaypoint() {
        return fromWaypoint;
    }

    public void setFromWaypoint(String fromWaypoint) {
        this.fromWaypoint = fromWaypoint;
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
    private String bearingT;
    private String bearingM;
    private String toWaypoint;
    private String fromWaypoint;


    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tBearingTrue: " + this.getBearingT()+ "\n");
        builder.append("\tBearingMagnetic: " + this.getBearingM() + "\n");
        builder.append("\tToWaypoint: " + this.getToWaypoint() + "\n");
        builder.append("\tFromWaypoint: " + this.getFromWaypoint() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Bearing Degrees", this.getBearingT(),"True");
        ct.addRow("Bearing Degrees", this.getBearingM(),"Magnetic");
        ct.addRow("TO Waypoint ID", this.getToWaypoint(), "");
        ct.addRow("FROM Waypoint ID", this.getFromWaypoint(), "");
        ct.print();
    }
}
