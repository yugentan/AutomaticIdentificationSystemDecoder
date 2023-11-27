package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class ALR {
    public ALR(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: ALR");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }

    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setTimeOfAlarmUTC(s[1]);
            setUniqueAlarmIdentifier(s[2]);
            setAlarmCondition(s[3].charAt(0));
            setAlarmAckState(s[4].charAt(0));
            setAlarmDescriptionText(s[5].split("\\*")[0]);
        }
            catch (Exception e){
                System.out.println("Sentence: " + _s + " contains invalid fields");
            }
        }
    public String getTimeOfAlarmUTC() {
        return timeOfAlarmUTC;
    }

    public void setTimeOfAlarmUTC(String timeOfAlarmUTC) {
        this.timeOfAlarmUTC = timeOfAlarmUTC;
    }

    public String getUniqueAlarmIdentifier() {
        return uniqueAlarmIdentifier;
    }

    public void setUniqueAlarmIdentifier(String uniqueAlarmIdentifier) {
        this.uniqueAlarmIdentifier = uniqueAlarmIdentifier;
    }

    public char getAlarmCondition() {
        return alarmCondition;
    }

    public void setAlarmCondition(char alarmCondition) {
        this.alarmCondition = alarmCondition;
    }

    public char getAlarmAckState() {
        return alarmAckState;
    }

    public void setAlarmAckState(char alarmAckState) {
        this.alarmAckState = alarmAckState;
    }

    public String getAlarmDescriptionText() {
        return alarmDescriptionText;
    }

    public void setAlarmDescriptionText(String alarmDescriptionText) {
        this.alarmDescriptionText = alarmDescriptionText;
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

    private String timeOfAlarmUTC;
    private String uniqueAlarmIdentifier;
    private char alarmCondition;
    private char alarmAckState;
    private String alarmDescriptionText;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tTimeOfAlarmConditionChange: " + this.getTimeOfAlarmUTC() + "\n");
        builder.append("\tUniqueAlarmNumber: " + this.getUniqueAlarmIdentifier() + "\n");
        builder.append("\tAlarmCondition: " + this.getAlarmCondition() + "\n");
        builder.append("\tAlarmAcknowledgeState: " + this.getAlarmAckState() + "\n");
        builder.append("\tAlarmDescriptionText: " + this.getAlarmDescriptionText() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Time of alarm condition change", this.getTimeOfAlarmUTC() ,"UTC");
        ct.addRow("Unique alarm number (identifier) at alarm source", this.getUniqueAlarmIdentifier() ,"");
        ct.addRow("Alarm condition", String.valueOf(this.getAlarmCondition()), Describer.describeAlarmCondition(this.getAlarmCondition()));
        ct.addRow("Alarm’s acknowledge state", String.valueOf(this.getAlarmAckState()) ,Describer.describeAlarmAck(this.getAlarmAckState()));
        ct.addRow("Alarm’s description text", this.getAlarmDescriptionText(),"");
        ct.print();
    }
}
