package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class FSI {
    public FSI(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: FSI");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setTransmittingFrequency(s[1]);
            setReceivingFrequency(s[2]);
            setModeOfOperation(s[3].charAt(0));
            setPowerLevel(Integer.parseInt(s[4].split("\\*")[0]));
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

    public String getTransmittingFrequency() {
        return transmittingFrequency;
    }

    public void setTransmittingFrequency(String transmittingFrequency) {
        this.transmittingFrequency = transmittingFrequency;
    }

    public String getReceivingFrequency() {
        return receivingFrequency;
    }

    public void setReceivingFrequency(String receivingFrequency) {
        this.receivingFrequency = receivingFrequency;
    }

    public char getModeOfOperation() {
        return modeOfOperation;
    }

    public void setModeOfOperation(char modeOfOperation) {
        this.modeOfOperation = modeOfOperation;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    private String transmittingFrequency;
    private String receivingFrequency;
    private char modeOfOperation;
    private int powerLevel;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tTransmittingFrequency: " + this.getTransmittingFrequency() + "\n");
        builder.append("\tReceivingFrequency: " + this.getReceivingFrequency()+ "\n");
        builder.append("\tModeOfOperation: " + this.getModeOfOperation() + "\n");
        builder.append("\tPowerLevel: " + this.getPowerLevel() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Transmitting Frequency", this.getTransmittingFrequency(),"");
        ct.addRow("Receiving Frequency", this.getReceivingFrequency(),"");
        ct.addRow("Mode of Operation",String.valueOf(this.getModeOfOperation()),Describer.describeOpMode(this.getModeOfOperation()));
        ct.addRow("Power Level", String.valueOf(this.getPowerLevel()),Describer.describePower(this.getPowerLevel()));
        ct.print();
    }
}
