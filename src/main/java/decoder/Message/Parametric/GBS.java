package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class GBS {
    public GBS(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GBS");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setUtcTime(s[1]);
            setLatErr(s[2]);
            setLongErr(s[3]);
            setAltErr(s[4]);
            setIdNumSatellite(s[5]);
            setProbability(s[6]);
            setEstimate(s[7]);
            setStd(s[8].split("\\*")[0]);
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

    public String getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }

    public String getLatErr() {
        return latErr;
    }

    public void setLatErr(String latErr) {
        this.latErr = latErr;
    }

    public String getLongErr() {
        return longErr;
    }

    public void setLongErr(String longErr) {
        this.longErr = longErr;
    }

    public String getAltErr() {
        return altErr;
    }

    public void setAltErr(String altErr) {
        this.altErr = altErr;
    }

    public String getIdNumSatellite() {
        return idNumSatellite;
    }

    public void setIdNumSatellite(String idNumSatellite) {
        this.idNumSatellite = idNumSatellite;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    private String utcTime;
    private String latErr;
    private String longErr;
    private String altErr;
    private String idNumSatellite;
    private String probability;
    private String estimate;
    private String std;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tUTCTimeOfFix: " + this.getUtcTime() + "\n");
        builder.append("\tExpectedLatitudeError: "+ this.getLatErr()+ "\n");
        builder.append("\tExpectedLongitudeError: " + this.getLongErr() + "\n");
        builder.append("\tExpectedAltitudeError: " + this.getAltErr() + "\n");
        builder.append("\tIDNumberOfFailedSatellite: " + this.getIdNumSatellite() + "\n");
        builder.append("\tProbabilityMissedDetection: " + this.getProbability() + "\n");
        builder.append("\tEstimatedBiasInMeters: " + this.getEstimate() + "\n");
        builder.append("\tStandardDeviationBiasEstimate: " + this.getStd() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("UTC time of the GGA or GNS fix associated", this.getUtcTime() , "HHMMSS.SS");
        ct.addRow("Expected Error in latitude", this.getLatErr(), "Meters");
        ct.addRow("Expected Error in longitude", this.getLongErr(), "Meters");
        ct.addRow("Expected Error in altitude", this.getAltErr(), "Meters");
        ct.addRow("ID number of most likely failed satellite", this.getIdNumSatellite(), "");
        ct.addRow("Probability of missed detection for most likely failed satellite", this.getProbability(), "");
        ct.addRow("Estimate of bias in meters on most likely failed satellite", this.getEstimate(), "Meters");
        ct.addRow("Standard deviation of bias estimate", this.getStd(), "");
        ct.print();
    }
}
