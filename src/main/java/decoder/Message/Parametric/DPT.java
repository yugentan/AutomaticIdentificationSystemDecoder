package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class DPT {
    public DPT(){};
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
            setWaterMeters(s[1]);
            setOffset(s[2]);
            setMaxRangeScale(s[3].split("\\*")[0]);
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

    public String getWaterMeters() {
        return waterMeters;
    }

    public void setWaterMeters(String waterMeters) {
        this.waterMeters = waterMeters;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getMaxRangeScale() {
        return maxRangeScale;
    }

    public void setMaxRangeScale(String maxRangeScale) {
        this.maxRangeScale = maxRangeScale;
    }

    private String waterMeters;
    private String offset;
    private String maxRangeScale;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tWaterDepthRelativeToTransducer: " + this.getWaterMeters() + "\n");
        builder.append("\tOffsetFromTransducer: " + this.getOffset() + "\n");
        builder.append("\tMaxRangeScaleInUse: " + this.getMaxRangeScale() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Water depth relative to the transducer", this.getWaterMeters() ,"Meters");
        ct.addRow("Offset from transducer", this.getOffset(), "Meters");
        ct.addRow("Maximum range scale in use", this.getMaxRangeScale(), "");
        ct.print();
    }
}
