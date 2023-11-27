package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class MTW {
    public MTW(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: MTW");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setTemperature(s[1] + " " + s[2].split("\\*")[0]);
        } catch (Exception e) {
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    private String temperature;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tTemperature: " + this.getTemperature() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Temperature", this.getTemperature(), "degrees C");
        ct.print();
    }
}
