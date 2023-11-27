package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class DBT {
    public DBT(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: DBT");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {}catch (Exception e){
            setWaterDepthFeet(s[1] + " " + s[2]);
            setWaterDepthMeters(s[3] + " " + s[4]);
            setWaterDepthFathoms(s[5] + " " + s[6].split("\\*")[0]);
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }
    private String waterDepthFeet;

    public String getWaterDepthFeet() {
        return waterDepthFeet;
    }

    public void setWaterDepthFeet(String waterDepthFeet) {
        this.waterDepthFeet = waterDepthFeet;
    }

    public String getWaterDepthMeters() {
        return waterDepthMeters;
    }

    public void setWaterDepthMeters(String waterDepthMeters) {
        this.waterDepthMeters = waterDepthMeters;
    }

    public String getWaterDepthFathoms() {
        return waterDepthFathoms;
    }

    public void setWaterDepthFathoms(String waterDepthFathoms) {
        this.waterDepthFathoms = waterDepthFathoms;
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

    private String waterDepthMeters;
    private String waterDepthFathoms;

    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tWaterDepthInFeet: " + this.getWaterDepthFeet() + "\n");
        builder.append("\tWaterDepthInMeters: " + this.getWaterDepthMeters() + "\n");
        builder.append("\tWaterDepthInFathoms: " + this.getWaterDepthFathoms() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Water Depth", this.getWaterDepthFeet(),"feet");
        ct.addRow("Water Depth", this.getWaterDepthMeters(),"Meters");
        ct.addRow("Water Depth", this.getWaterDepthFathoms(),"Fathoms");
        ct.print();
    }
}
