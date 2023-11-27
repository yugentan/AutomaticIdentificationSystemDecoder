package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class ALM {
    public ALM(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: ALM");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }

    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setTotalSentence(Integer.parseInt(s[1]));
            setSentenceNumber(Integer.parseInt(s[2]));
            setSatellitePRNNumber(Integer.parseInt(s[3]));
            setGpsWeekNumber(s[4]);
            setSvHealth(String.valueOf(Integer.parseInt(s[5],16)));
            setEccentricity(String.valueOf(Integer.parseInt(s[6],16)));
            setAlmanacRefTime(String.valueOf(Integer.parseInt(s[7],16)));
            setInclinationAngle(String.valueOf(Integer.parseInt(s[8],16)));
            setRateOfRightAscension(String.valueOf(Integer.parseInt(s[9],16)));
            setRootOfSemiMajorAxis(String.valueOf(Integer.parseInt(s[10],16)));
            setArgumentOfPerigee(String.valueOf(Integer.parseInt(s[11],16)));
            setLongitudeOfAscensionNode(String.valueOf(Integer.parseInt(s[12],16)));
            setMeanAnomaly(String.valueOf(Integer.parseInt(s[13],16)));
            setF0Clock(String.valueOf(Integer.parseInt(s[14],16)));
            setF1Clock(String.valueOf(Integer.parseInt(s[15].split("\\*")[0],16)));
        }catch (Exception e){
        System.out.println("Sentence: " + _s + " contains invalid fields");
    }
}
    public int getTotalSentence() {
        return totalSentence;
    }

    public void setTotalSentence(int totalSentence) {
        this.totalSentence = totalSentence;
    }

    public int getSentenceNumber() {
        return sentenceNumber;
    }

    public void setSentenceNumber(int sentenceNumber) {
        this.sentenceNumber = sentenceNumber;
    }

    public int getSatellitePRNNumber() {
        return satellitePRNNumber;
    }

    public void setSatellitePRNNumber(int satellitePRNNumber) {
        this.satellitePRNNumber = satellitePRNNumber;
    }

    public String getGpsWeekNumber() {
        return gpsWeekNumber;
    }

    public void setGpsWeekNumber(String gpsWeekNumber) {
        this.gpsWeekNumber = gpsWeekNumber;
    }

    public String getSvHealth() {
        return svHealth;
    }

    public void setSvHealth(String svHealth) {
        this.svHealth = svHealth;
    }

    public String getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(String eccentricity) {
        this.eccentricity = eccentricity;
    }

    public String getAlmanacRefTime() {
        return almanacRefTime;
    }

    public void setAlmanacRefTime(String almanacRefTime) {
        this.almanacRefTime = almanacRefTime;
    }

    public String getInclinationAngle() {
        return inclinationAngle;
    }

    public void setInclinationAngle(String inclinationAngle) {
        this.inclinationAngle = inclinationAngle;
    }

    public String getRateOfRightAscension() {
        return rateOfRightAscension;
    }

    public void setRateOfRightAscension(String rateOfRightAscension) {
        this.rateOfRightAscension = rateOfRightAscension;
    }

    public String getRootOfSemiMajorAxis() {
        return rootOfSemiMajorAxis;
    }

    public void setRootOfSemiMajorAxis(String rootOfSemiMajorAxis) {
        this.rootOfSemiMajorAxis = rootOfSemiMajorAxis;
    }

    public String getArgumentOfPerigee() {
        return argumentOfPerigee;
    }

    public void setArgumentOfPerigee(String argumentOfPerigee) {
        this.argumentOfPerigee = argumentOfPerigee;
    }

    public String getLongitudeOfAscensionNode() {
        return longitudeOfAscensionNode;
    }

    public void setLongitudeOfAscensionNode(String longitudeOfAscensionNode) {
        this.longitudeOfAscensionNode = longitudeOfAscensionNode;
    }

    public String getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(String meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

    public String getF0Clock() {
        return f0Clock;
    }

    public void setF0Clock(String f0Clock) {
        this.f0Clock = f0Clock;
    }

    public String getF1Clock() {
        return f1Clock;
    }

    public void setF1Clock(String f1Clock) {
        this.f1Clock = f1Clock;
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

    private int totalSentence;
    private int sentenceNumber;
    private int satellitePRNNumber;
    private String gpsWeekNumber;
    private String svHealth;
    private String eccentricity;
    private String almanacRefTime;
    private String inclinationAngle;
    private String rateOfRightAscension;
    private String rootOfSemiMajorAxis;
    private String argumentOfPerigee;
    private String longitudeOfAscensionNode;
    private String meanAnomaly;
    private String f0Clock;
    private String f1Clock;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tTotalNumberOfMessage: " + this.getTotalSentence() + "\n");
        builder.append("\tSentenceNumber: " + this.getSentenceNumber() + "\n");
        builder.append("\tSatellitePRNNumber: " + this.getSatellitePRNNumber() + "\n");
        builder.append("\tGPSWeekNumber: " + this.getGpsWeekNumber() + "\n");
        builder.append("\tSVHealth: " + this.getSvHealth() + "\n");
        builder.append("\tEccentricity: " + this.getEccentricity() + "\n");
        builder.append("\tAlmanacRefTime: " + this.getAlmanacRefTime() + "\n");
        builder.append("\tInclinationAngle: " + this.getInclinationAngle() + "\n");
        builder.append("\tRateOfRightAscension: " + this.getRateOfRightAscension() + "\n");
        builder.append("\tRootOfSemiMajorAxis: " + this.getRootOfSemiMajorAxis() + "\n");
        builder.append("\tArgumentOfPerigee: " + this.getArgumentOfPerigee() + "\n");
        builder.append("\tLongitudeOfAscension: " + this.getLongitudeOfAscensionNode() + "\n");
        builder.append("\tMeanAnomaly: " + this.getMeanAnomaly() + "\n");
        builder.append("\tF0ClockParameter: " + this.getF0Clock() + "\n");
        builder.append("\tF1ClockParameter: " + this.getF1Clock()+ "\n");
        builder.append("}");
        return builder.toString();
    }

    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Total number of messages", String.valueOf(this.getTotalSentence()), "");
        ct.addRow("Sentence Number", String.valueOf(this.getSentenceNumber()) , "");
        ct.addRow("Satellite PRN number (01 to 32)", String.valueOf(this.getSatellitePRNNumber()), "");
        ct.addRow("GPS Week Number", String.valueOf(this.getGpsWeekNumber()), "");
        ct.addRow("SV health, bits 17-24 of each almanac page", this.getSvHealth(), "");
        ct.addRow("Eccentricity", this.getEccentricity(), "");
        ct.addRow("Almanac Reference Time",this.getAlmanacRefTime(), "");
        ct.addRow("Inclination Angle",this.getInclinationAngle(), "");
        ct.addRow("Rate of Right Ascension",this.getRateOfRightAscension(), "");
        ct.addRow("Root of semi-major axis",this.getRootOfSemiMajorAxis(), "");
        ct.addRow("Argument of perigee",this.getArgumentOfPerigee(), "");
        ct.addRow("Longitude of ascension node",this.getLongitudeOfAscensionNode(), "");
        ct.addRow("Mean anomaly",this.getMeanAnomaly(), "");
        ct.addRow("F0 Clock Parameter",this.getF0Clock(), "");
        ct.addRow("F1 Clock Parameter",this.getF1Clock(), "");
        ct.print();
    }
}
