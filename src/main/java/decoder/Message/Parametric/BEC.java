package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class BEC {
    public BEC(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: BEC");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setUtcObservation(s[1]);
            setWaypointLat(s[2]+ " " + s[3]);
            setWaypointLong(s[4] + " " + s[5]);
            setBearingT(s[6] + " " + s[7]);
            setBearingM(s[8] + " " +s[9]);
            setDistance(s[10] + " " +s[11]);
            setWaypointID(s[12].split("\\*")[0]);
        }catch (Exception e){
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }

    public String getUtcObservation() {
        return utcObservation;
    }

    public void setUtcObservation(String utcObservation) {
        this.utcObservation = utcObservation;
    }

    public String getWaypointLat() {
        return waypointLat;
    }

    public void setWaypointLat(String waypointLat) {
        this.waypointLat = waypointLat;
    }

    public String getWaypointLong() {
        return waypointLong;
    }

    public void setWaypointLong(String waypointLong) {
        this.waypointLong = waypointLong;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getWaypointID() {
        return waypointID;
    }

    public void setWaypointID(String waypointID) {
        this.waypointID = waypointID;
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

    private String utcObservation;
    private String waypointLat;
    private String waypointLong;
    private String bearingT;
    private String bearingM;
    private String distance;
    private String waypointID;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tUTCOfObservation: " + this.getUtcObservation() + "\n");
        builder.append("\tWaypointLatitude: " + this.getWaypointLat() + "\n");
        builder.append("\tWaypointLongitude: " + this.getWaypointLong() + "\n");
        builder.append("\tBearingDegreeTrue: " + this.getBearingT() + "\n");
        builder.append("\tBearingDegreeMagnetic: " + this.getBearingM() + "\n");
        builder.append("\tDistance: " + this.getDistance() + "\n");
        builder.append("\tWaypointID: " + this.getWaypointID()+ "\n");
        builder.append("}");

      return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("UTC of observation", this.getUtcObservation(),"");
        ct.addRow("Waypoint latitude, N/S ", this.getWaypointLat(),"North / South");
        ct.addRow("Waypoint longitude, E/W", this.getWaypointLong(),"East / West");
        ct.addRow("Bearing, degrees True", this.getBearingT(),"True");
        ct.addRow("Bearing, degrees Magnetic ", this.getBearingM(),"Magnetic");
        ct.addRow("Distance", this.getDistance(),"Nautical Miles");
        ct.addRow("Waypoint ID", this.getWaypointID(),"");
        ct.print();
    }
}
