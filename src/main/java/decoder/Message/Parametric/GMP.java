package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class GMP {
    public GMP(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GMP");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setUtcPos(s[1]);
            setMapProjectionID(s[2]);
            setMapZone(s[3]);
            setxCord(s[4]);
            setyCord(s[5]);
            setModeIndicator(s[6]);
            setNumbSatelliteInUse(s[7]);
            setHdop(s[8]);
            setAntennaAltitude(s[9]);
            setGeoidalSeparation(s[10]);
            setAgeOfDifferentialData(s[11]);
            setDifferentialRefStationID(s[12].split("\\*")[0]);
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
    private String utcPos;
    private String mapProjectionID;
    private String mapZone;
    private String xCord;
    private String yCord;
    private String modeIndicator;
    private String numbSatelliteInUse;
    private String hdop;

    public String getUtcPos() {
        return utcPos;
    }

    public void setUtcPos(String utcPos) {
        this.utcPos = utcPos;
    }

    public String getMapProjectionID() {
        return mapProjectionID;
    }

    public void setMapProjectionID(String mapProjectionID) {
        this.mapProjectionID = mapProjectionID;
    }

    public String getMapZone() {
        return mapZone;
    }

    public void setMapZone(String mapZone) {
        this.mapZone = mapZone;
    }

    public String getxCord() {
        return xCord;
    }

    public void setxCord(String xCord) {
        this.xCord = xCord;
    }

    public String getyCord() {
        return yCord;
    }

    public void setyCord(String yCord) {
        this.yCord = yCord;
    }

    public String getModeIndicator() {
        return modeIndicator;
    }

    public void setModeIndicator(String modeIndicator) {
        this.modeIndicator = modeIndicator;
    }

    public String getNumbSatelliteInUse() {
        return numbSatelliteInUse;
    }

    public void setNumbSatelliteInUse(String numbSatelliteInUse) {
        this.numbSatelliteInUse = numbSatelliteInUse;
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

    public String getAgeOfDifferentialData() {
        return ageOfDifferentialData;
    }

    public void setAgeOfDifferentialData(String ageOfDifferentialData) {
        this.ageOfDifferentialData = ageOfDifferentialData;
    }

    public String getDifferentialRefStationID() {
        return differentialRefStationID;
    }

    public void setDifferentialRefStationID(String differentialRefStationID) {
        this.differentialRefStationID = differentialRefStationID;
    }

    private String antennaAltitude;
    private String geoidalSeparation;
    private String ageOfDifferentialData;
    private String differentialRefStationID;
    private String talker;
    private String format;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tUTCOfPosition: " + this.getUtcPos() + "\n");
        builder.append("\tMapProjectionID: " + this.getMapProjectionID()+ "\n");
        builder.append("\tMapZone: " + this.getMapZone() + "\n");
        builder.append("\tXcord: " + this.getxCord() + "\n");
        builder.append("\tYcord: " + this.getyCord() + "\n");
        builder.append("\tModeIndicator: " + this.getModeIndicator() + "\n");
        builder.append("\tTotalNumberSatelliteInUse: " + this.getNumbSatelliteInUse() + "\n");
        builder.append("\tHDOP: " + this.getHdop()+ "\n");
        builder.append("\tAntennaAltitude: " + this.getAntennaAltitude() + "\n");
        builder.append("\tGeoidalSeparation: " + this.getGeoidalSeparation() + "\n");
        builder.append("\tAgeOfDifferentialData: " + this.getAgeOfDifferentialData() + "\n");
        builder.append("\tDifferentialRefStationID: " + this.getDifferentialRefStationID() + "\n");
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
        ct.addRow("Map projection identification", this.getMapProjectionID(),Describer.describeMapProjection(this.getMapProjectionID()));
        ct.addRow("Map zone", this.getMapZone(),"");
        ct.addRow("X (Northern) component of grid (or local) coordinates", this.getxCord(),"");
        ct.addRow("Y (Eastern) component of grid (or local) coordinates", this.getyCord(),"");
        ct.addRow("Mode indicator", this.getModeIndicator(),Describer.describeMapMode(this.getModeIndicator()));
        ct.addRow("Total number of satellites in use", this.getNumbSatelliteInUse(),"00-99");
        ct.addRow("HDOP", this.getHdop(),"");
        ct.addRow("Antenna altitude", this.getAntennaAltitude(),"meters");
        ct.addRow("Geoidal separation", this.getGeoidalSeparation(),"meters");
        ct.addRow("Age of differential data", this.getAgeOfDifferentialData(),"");
        ct.addRow("Differential reference station ID", this.getDifferentialRefStationID(),"");
        ct.print();
    }
}
