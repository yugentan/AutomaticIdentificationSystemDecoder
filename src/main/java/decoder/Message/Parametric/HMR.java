package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class HMR {
    public HMR(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: HMR");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setHeadingSensor1(s[1]);
            setHeadingSensor2(s[2]);
            setDifferenceLimitSetting(s[3]);
            setActualHeadingSensorDifference(s[4]);
            setWarningFlag(s[5]);
            setHeadingRead1(s[6]);
            setStatus1(s[7]);
            setSensorType1(s[8]);
            setSensorDeviation1(s[9]);
            setDevUnit1(s[10]);
            setHeadingRead2(s[11]);
            setStatus2(s[12]);
            setSensorType2(s[13]);
            setSensorDeviation2(s[14]);
            setDevUnit2(s[15]);
            setVariation(s[16]);
            setVariationUnit(s[17].split("\\*")[0]);
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

    public String getDifferenceLimitSetting() {
        return differenceLimitSetting;
    }

    public void setDifferenceLimitSetting(String differenceLimitSetting) {
        this.differenceLimitSetting = differenceLimitSetting;
    }

    public String getActualHeadingSensorDifference() {
        return actualHeadingSensorDifference;
    }

    public void setActualHeadingSensorDifference(String actualHeadingSensorDifference) {
        this.actualHeadingSensorDifference = actualHeadingSensorDifference;
    }

    public String getWarningFlag() {
        return warningFlag;
    }

    public void setWarningFlag(String warningFlag) {
        this.warningFlag = warningFlag;
    }

    public String getHeadingRead1() {
        return headingRead1;
    }

    public void setHeadingRead1(String headingRead1) {
        this.headingRead1 = headingRead1;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getSensorType1() {
        return sensorType1;
    }

    public void setSensorType1(String sensorType1) {
        this.sensorType1 = sensorType1;
    }

    public String getSensorDeviation1() {
        return sensorDeviation1;
    }

    public void setSensorDeviation1(String sensorDeviation1) {
        this.sensorDeviation1 = sensorDeviation1;
    }

    public String getHeadingRead2() {
        return headingRead2;
    }

    public void setHeadingRead2(String headingRead2) {
        this.headingRead2 = headingRead2;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getSensorType2() {
        return sensorType2;
    }

    public void setSensorType2(String sensorType2) {
        this.sensorType2 = sensorType2;
    }

    public String getSensorDeviation2() {
        return sensorDeviation2;
    }

    public void setSensorDeviation2(String sensorDeviation2) {
        this.sensorDeviation2 = sensorDeviation2;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getVariationUnit() {
        return variationUnit;
    }

    public void setVariationUnit(String variationUnit) {
        this.variationUnit = variationUnit;
    }
    public String getDevUnit1() {
        return devUnit1;
    }

    public void setDevUnit1(String devUnit1) {
        this.devUnit1 = devUnit1;
    }

    public String getDevUnit2() {
        return devUnit2;
    }

    public void setDevUnit2(String devUnit2) {
        this.devUnit2 = devUnit2;
    }


    private String headingSensor2;
    private String differenceLimitSetting;
    private String actualHeadingSensorDifference;
    private String warningFlag;
    private String headingRead1;
    private String status1;
    private String sensorType1;
    private String sensorDeviation1;
    private String devUnit1;
    private String devUnit2;


    private String headingRead2;
    private String status2;
    private String sensorType2;
    private String sensorDeviation2;
    private String variation;
    private String variationUnit;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tHeadingSensor1ID: " + this.getHeadingSensor1()+ "\n");
        builder.append("\tHeadingSensor2ID: " + this.getHeadingSensor2()+ "\n");
        builder.append("\tDifferenceLimitSettings: " +this.getDifferenceLimitSetting()+ "\n");
        builder.append("\tActualHeadingSensorDifference: " +this.getActualHeadingSensorDifference()+ "\n");
        builder.append("\tWarningFlag: " +this.getWarningFlag()+ "\n");
        builder.append("\tSensor1HeadingReading: " +this.getHeadingRead1()+ "\n");
        builder.append("\tSensor1Status: " +this.getStatus1()+ "\n");
        builder.append("\tSensor1Type: " +this.getSensorType1()+ "\n");
        builder.append("\tSensor1Deviation: " +this.getSensorDeviation1() + " " + this.getDevUnit1() + "\n");
        builder.append("\tSensor2HeadingReading: " +this.getHeadingRead2()+ "\n");
        builder.append("\tSensor2Status: " +this.getStatus2()+ "\n");
        builder.append("\tSensor2Type: " +this.getSensorType2()+ "\n");
        builder.append("\tSensor2Deviation: " +this.getSensorDeviation2() +" "+this.getDevUnit2()+ "\n");
        builder.append("\tVariation: " +this.getVariation() +" "+this.getVariationUnit()+ "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Heading Sensor 1 ID", this.getHeadingSensor1(),"");
        ct.addRow("Heading Sensor 2 ID", this.getHeadingSensor2(),"");
        ct.addRow("Difference limit setting", this.getDifferenceLimitSetting(),"degrees");
        ct.addRow("Actual heading sensor difference", this.getActualHeadingSensorDifference(),"degrees");
        ct.addRow("Warning flag", this.getWarningFlag(),Describer.describeHmrWarn(this.getWarningFlag()));
        ct.addRow("Heading reading, Sensor 1", this.getHeadingRead1() ,"degrees");
        ct.addRow("Status, Sensor 1", this.getStatus1(),Describer.describeCurrentData(this.getStatus1().charAt(0)));
        ct.addRow("Sensor 1 type", this.getSensorType1(),Describer.describeMagnetic(this.getSensorType1().charAt(0)));
        ct.addRow("Deviation, Sensor 1", this.getSensorDeviation1(),Describer.describeDeviation(this.getDevUnit1()));
        ct.addRow("Heading reading, Sensor 2", this.getHeadingRead2(),"degrees");
        ct.addRow("Status, Sensor 2", this.getStatus2(),Describer.describeCurrentData(this.getStatus2().charAt(0)));
        ct.addRow("Sensor 2 type", this.getSensorType2(),Describer.describeMagnetic(this.getSensorType2().charAt(0)));
        ct.addRow("Deviation, Sensor 2", this.getSensorDeviation2(),Describer.describeDeviation(this.getDevUnit2()));
        ct.addRow("Variation",this.getVariation(),Describer.describeDeviation(this.getVariationUnit()));
        ct.print();
    }
}
