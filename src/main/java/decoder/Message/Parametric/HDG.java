package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class HDG {
    public HDG(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: BOD");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setSensor(s[1]);
            setDeviation(s[2]);
            setDeviationDir(s[3]);
            setVariation(s[4]);
            setVariationDir(s[5].split("\\*")[0]);
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
    private String sensor;
    private String deviation;
    private String deviationDir;
    private String variation;

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getDeviation() {
        return deviation;
    }

    public void setDeviation(String deviation) {
        this.deviation = deviation;
    }

    public String getDeviationDir() {
        return deviationDir;
    }

    public void setDeviationDir(String deviationDir) {
        this.deviationDir = deviationDir;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getVariationDir() {
        return variationDir;
    }

    public void setVariationDir(String variationDir) {
        this.variationDir = variationDir;
    }

    private String variationDir;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tMagneticSensorHeading: " + this.getSensor() + "\n");
        builder.append("\tMagneticDeviation: " +this.getDeviation() + "\n");
        builder.append("\tMagneticDeviationDirection: " + this.getDeviationDir() + "\n");
        builder.append("\tMagneticVariation: " +this.getVariation() + "\n");
        builder.append("\tMagneticVariationDirection: " + this.getVariationDir() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Magnetic Sensor heading", this.getSensor(),"degrees");
        ct.addRow("Magnetic Deviation", this.getDeviation() ,Describer.describeDeviation(this.getDeviation()));
        ct.addRow("Magnetic Variation", this.getVariation(), Describer.describeDeviation(this.getVariation()));
        ct.print();
    }
}
