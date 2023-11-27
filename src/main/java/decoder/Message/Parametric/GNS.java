package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class GNS {
    public GNS(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GNS");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setUtcPos(s[1]);
            setLatitude(s[2] + " " + s[3]);
            setLongitude(s[4] + " " + s[5]);
            setModeIndicator(s[6]);
            setTotalNumSatellite(s[7]);
            setHdop(s[8]);
            setAntennaAltitude(s[9]);
            setGeoidalSeparation(s[10]);
            setAgeOfDifferential(s[11]);
            setDifferentialStationID(s[12].split("\\*")[0]);
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

    private String utcPos;
    private String latitude;
    private String longitude;
    private String modeIndicator;
    private String totalNumSatellite;
    private String hdop;
    private String antennaAltitude;
    private String geoidalSeparation;
    private String ageOfDifferential;
    private String differentialStationID;

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

    public String getModeIndicator() {
        return modeIndicator;
    }

    public void setModeIndicator(String modeIndicator) {
        this.modeIndicator = modeIndicator;
    }

    public String getTotalNumSatellite() {
        return totalNumSatellite;
    }

    public void setTotalNumSatellite(String totalNumSatellite) {
        this.totalNumSatellite = totalNumSatellite;
    }

    public String getHdop() {
        return hdop;
    }

    public void setHdop(String hdop) {
        this.hdop = hdop;
    }

    public String getAntennaAltitude() {
        return antennaAltitude;
    }

    public void setAntennaAltitude(String antennaAltitude) {
        this.antennaAltitude = antennaAltitude;
    }

    public String getGeoidalSeparation() {
        return geoidalSeparation;
    }

    public void setGeoidalSeparation(String geoidalSeparation) {
        this.geoidalSeparation = geoidalSeparation;
    }

    public String getAgeOfDifferential() {
        return ageOfDifferential;
    }

    public void setAgeOfDifferential(String ageOfDifferential) {
        this.ageOfDifferential = ageOfDifferential;
    }

    public String getDifferentialStationID() {
        return differentialStationID;
    }

    public void setDifferentialStationID(String differentialStationID) {
        this.differentialStationID = differentialStationID;
    }

    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tUTCOfPosition: " + this.getUtcPos()+ "\n");
        builder.append("\tLatitude: " + this.getLatitude() + "\n");
        builder.append("\tLongitude: " + this.getLongitude() + "\n");
        builder.append("\tModeIndicator: " + this.getModeIndicator() + "\n");
        builder.append("\tTotalSatelliteInUse: " + this.getTotalNumSatellite() + "\n");
        builder.append("\tHDOP: " + this.getHdop()+ "\n");
        builder.append("\tAntennaAltitude: " + this.getAntennaAltitude() + "\n");
        builder.append("\tGeoidalSeparation: " + this.getGeoidalSeparation() + "\n");
        builder.append("\tAgeOfDifferential: " + this.getAgeOfDifferential() + "\n");
        builder.append("\tDifferentialReferenceStationID: " + this.getDifferentialStationID() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("UTC of position", this.getUtcPos(),"HHMMSS.SS");
        ct.addRow("Latitude", this.getLatitude(),"North / South");
        ct.addRow("Longitude", this.getLongitude(),"East / West");
        ct.addRow("Mode indicator", this.getModeIndicator() ,Describer.describeMapMode(this.getModeIndicator()));
        ct.addRow("Total number of satellites in use", this.getTotalNumSatellite(),"");
        ct.addRow("HDOP", this.getHdop(),"");
        ct.addRow("Antenna altitude", this.getAntennaAltitude(),"meters");
        ct.addRow("Goeidal separation", this.getGeoidalSeparation(),"meters");
        ct.addRow("Age of differential data", this.getAgeOfDifferential(),"");
        ct.addRow("Differential reference station ID", this.getDifferentialStationID(),"");
        ct.print();
    }
}
