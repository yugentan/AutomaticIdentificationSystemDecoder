package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
/**[GLOBALSAT] describes a completely different meaning for this sentence, having to do with water temperature sensors. It is unclear which is correct.*/
public class HSC {
    public HSC(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: HSC");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setCommandHeadingTrue(s[1] + " " +s[2]);
            setCommandHeadingMagnetic(s[3] + " " + s[4].split("\\*"));
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
    private String commandHeadingTrue;

    public String getCommandHeadingTrue() {
        return commandHeadingTrue;
    }

    public void setCommandHeadingTrue(String commandHeadingTrue) {
        this.commandHeadingTrue = commandHeadingTrue;
    }

    public String getCommandHeadingMagnetic() {
        return commandHeadingMagnetic;
    }

    public void setCommandHeadingMagnetic(String commandHeadingMagnetic) {
        this.commandHeadingMagnetic = commandHeadingMagnetic;
    }

    private String commandHeadingMagnetic;
    private String talker;
    private String format;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tCommandedHeadingTrue: " + this.getCommandHeadingTrue()+ "\n");
        builder.append("\tCommandedHeadingMagnetic: " + this.getCommandHeadingMagnetic()+ "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Commanded Heading", this.getCommandHeadingTrue(), "True (degrees)");
        ct.addRow("Commanded Heading", this.getCommandHeadingMagnetic(), "Magnetic (degrees)");
        ct.print();
    }
}
