package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class ACK {
    public ACK(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: ACK");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setUniqueAlarmNumber(s[1].split("\\*")[0]);
        }catch (Exception e){
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }

    public String getUniqueAlarmNumber() {
        return uniqueAlarmNumber;
    }

    public void setUniqueAlarmNumber(String uniqueAlarmNumber) {
        this.uniqueAlarmNumber = uniqueAlarmNumber;
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

    private String uniqueAlarmNumber;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tUniqueAlarmNumber: " + this.getUniqueAlarmNumber() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable() {
        CommandTable ct = new CommandTable();
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Unique alarm number (identifier) at alarm source", this.getUniqueAlarmNumber(), "");
        ct.setShowVerticalLines(true);
        ct.print();
    }
}
