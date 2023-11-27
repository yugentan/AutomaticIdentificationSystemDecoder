package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class HMS {
    public HMS(){};
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
            setHeadingSensor1(s[1]);
            setHeadingSensor2(s[2]);
            setMaxDiff(s[3].split("\\*")[0]);
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
    private String headingSensor1;
    private String headingSensor2;
    private String maxDiff;

    public String getHeadingSensor1() {
        return headingSensor1;
    }

    public void setHeadingSensor1(String headingSensor1) {
        this.headingSensor1 = headingSensor1;
    }

    public String getHeadingSensor2() {
        return headingSensor2;
    }

    public void setHeadingSensor2(String headingSensor2) {
        this.headingSensor2 = headingSensor2;
    }

    public String getMaxDiff() {
        return maxDiff;
    }

    public void setMaxDiff(String maxDiff) {
        this.maxDiff = maxDiff;
    }

    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tHeadingSensor1ID: " + this.getHeadingSensor1()+ "\n");
        builder.append("\tHeadingSensor2ID: " + this.getHeadingSensor2() + "\n");
        builder.append("\tMaximumDifference: " + this.getMaxDiff() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Heading Sensor 1 ID",this.getHeadingSensor1(),"");
        ct.addRow("Heading Sensor 2 ID",this.getHeadingSensor2(),"");
        ct.addRow("Maximum difference",this.getMaxDiff(),"degrees");
        ct.print();
    }
}
