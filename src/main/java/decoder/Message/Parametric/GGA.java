package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class GGA {
    public GGA(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GGA");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setUtcReport(s[1]);
            setLatitude(s[2] + " " + s[3]);
            setLongitude(s[4] + " " + s[5]);
            setGpsQuality(s[6].charAt(0));
            setNumbSatelliteUse(s[7]);
            setHorizontalDilution(s[8]);
            setAntennaAltitude(s[9] + " " + s[10]);
            setGeoidalSeparation(s[11] + " " + s[12]);
            setAgeOfDifferential(s[13]);
            setDifferentialRefStationID(s[14].split("\\*")[0]);
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
    private String utcReport;
    private String latitude;

    public String getUtcReport() {
        return utcReport;
    }

    public void setUtcReport(String utcReport) {
        this.utcReport = utcReport;
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

    public char getGpsQuality() {
        return gpsQuality;
    }

    public void setGpsQuality(char gpsQuality) {
        this.gpsQuality = gpsQuality;
    }

    public String getNumbSatelliteUse() {
        return numbSatelliteUse;
    }

    public void setNumbSatelliteUse(String numbSatelliteUse) {
        this.numbSatelliteUse = numbSatelliteUse;
    }

    public String getHorizontalDilution() {
        return horizontalDilution;
    }

    public void setHorizontalDilution(String horizontalDilution) {
        this.horizontalDilution = horizontalDilution;
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

    public String getDifferentialRefStationID() {
        return differentialRefStationID;
    }

    public void setDifferentialRefStationID(String differentialRefStationID) {
        this.differentialRefStationID = differentialRefStationID;
    }

    private String longitude;
    private char gpsQuality;
    private String numbSatelliteUse;
    private String horizontalDilution;
    private String antennaAltitude;
    private String geoidalSeparation;
    private String ageOfDifferential;
    private String differentialRefStationID;
    private String talker;
    private String format;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tUTCOfPosition: " + this.getUtcReport() + "\n");
        builder.append("\tLatitude: " + this.getLatitude() + "\n");
        builder.append("\tLongitude: " + this.getLongitude() + "\n");
        builder.append("\tGPSQuality: " + this.getGpsQuality()+ "\n");
        builder.append("\tNumberOfSatellite: " + this.getNumbSatelliteUse()+ "\n");
        builder.append("\tHorizontalDilutionOfPrecision: " + this.getHorizontalDilution()+ "\n");
        builder.append("\tAntennaAltitude: " + this.getAntennaAltitude() + "\n");
        builder.append("\tGeoidalSeparation: " + this.getGeoidalSeparation() + "\n");
        builder.append("\tAgeOfDifferential: " + this.getAgeOfDifferential() + "\n");
        builder.append("\tDifferentialReferenceStationID: " + this.getDifferentialRefStationID() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("UTC of position", this.getUtcReport(),"hhmmss.ss");
        ct.addRow("Latitude", this.getLatitude(),"North / South");
        ct.addRow("Longitude", this.getLongitude(),"East / West");
        ct.addRow("GPS Quality indicator",String.valueOf(this.getGpsQuality()), Describer.describeGPSQuality(this.getGpsQuality()));
        ct.addRow("Number of satellites in use", this.getNumbSatelliteUse(),"");
        ct.addRow("Horizontal dilution of precision ", this.getHorizontalDilution(),"");
        ct.addRow("Altitude re: mean-sea-level (geoid)", this.getAntennaAltitude() ,"meters");
        ct.addRow("Geoidal separation", this.getGeoidalSeparation(),"meters");
        ct.addRow("Age of Differential GPS data", this.getAgeOfDifferential(),"");
        ct.addRow("Differential reference station ID", this.getDifferentialRefStationID(),"");
        ct.print();
    }
}
