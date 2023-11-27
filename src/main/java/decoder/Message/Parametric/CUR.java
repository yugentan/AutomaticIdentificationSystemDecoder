package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class CUR {
    public CUR(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: CUR");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setValidity(s[1].charAt(0));
            setDataSetNumber(s[2]);
            setLayerNumber(s[3]);
            setCurrentDepthMeters(s[4]);
            setCurrentDirDegrees(s[5]);
            setDirRef(s[6].charAt(0));
            setCurrentSpeedKnots(s[7]);
            setRefLayerDepthMeters(s[8]);
            setHeading(s[9]);
            setHeadingRef(s[10].charAt(0));
            setSpeedChar(s[11].split("\\*")[0].charAt(0));
        }catch (Exception e){
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }

    public char getValidity() {
        return validity;
    }

    public void setValidity(char validity) {
        this.validity = validity;
    }

    public String getDataSetNumber() {
        return dataSetNumber;
    }

    public void setDataSetNumber(String dataSetNumber) {
        this.dataSetNumber = dataSetNumber;
    }

    public String getLayerNumber() {
        return layerNumber;
    }

    public void setLayerNumber(String layerNumber) {
        this.layerNumber = layerNumber;
    }

    public String getCurrentDepthMeters() {
        return currentDepthMeters;
    }

    public void setCurrentDepthMeters(String currentDepthMeters) {
        this.currentDepthMeters = currentDepthMeters;
    }

    public String getCurrentDirDegrees() {
        return currentDirDegrees;
    }

    public void setCurrentDirDegrees(String currentDirDegrees) {
        this.currentDirDegrees = currentDirDegrees;
    }

    public char getDirRef() {
        return dirRef;
    }

    public void setDirRef(char dirRef) {
        this.dirRef = dirRef;
    }

    public String getCurrentSpeedKnots() {
        return currentSpeedKnots;
    }

    public void setCurrentSpeedKnots(String currentSpeedKnots) {
        this.currentSpeedKnots = currentSpeedKnots;
    }

    public String getRefLayerDepthMeters() {
        return refLayerDepthMeters;
    }

    public void setRefLayerDepthMeters(String refLayerDepthMeters) {
        this.refLayerDepthMeters = refLayerDepthMeters;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public char getHeadingRef() {
        return headingRef;
    }

    public void setHeadingRef(char headingRef) {
        this.headingRef = headingRef;
    }

    public char getSpeedChar() {
        return speedChar;
    }

    public void setSpeedChar(char speedChar) {
        this.speedChar = speedChar;
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

    private char validity;
    private String dataSetNumber;
    private String layerNumber;
    private String currentDepthMeters;
    private String currentDirDegrees;
    private char dirRef;
    private String currentSpeedKnots;
    private String refLayerDepthMeters;
    private String heading;
    private char headingRef;
    private char speedChar;

    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tValidityOfData: " + this.getValidity() + "\n");
        builder.append("\tDataSetNumber: " + this.getDataSetNumber() + "\n");
        builder.append("\tLayerNumber: " + this.getLayerNumber() + "\n");
        builder.append("\tCurrentDeptInMeters: " + this.getCurrentDepthMeters()+ "\n");
        builder.append("\tCurrentDirectionInDegrees: " + this.getCurrentDirDegrees() + "\n");
        builder.append("\tDirectionReference: " + this.getDirRef() + "\n");
        builder.append("\tCurrentSpeedInKnots: " + this.getCurrentSpeedKnots()+ "\n");
        builder.append("\tReferenceLayerDepthInMeters: " + this.getRefLayerDepthMeters() + "\n");
        builder.append("\tHeading: " + this.getHeading() + "\n");
        builder.append("\tHeadingReference: " + this.getHeadingRef() + "\n");
        builder.append("\tSpeedReference: " + this.getSpeedChar() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Validity Of Data",String.valueOf(this.getValidity()), Describer.describeCurrentData(this.getValidity()));
        ct.addRow("Data Set Number", this.getDataSetNumber(),"");
        ct.addRow("Layer Number", this.getLayerNumber(),"");
        ct.addRow("Current Depth", this.getCurrentDepthMeters(),"Meters");
        ct.addRow("Current Direction", this.getCurrentDirDegrees(),"Degrees");
        ct.addRow("Direction Reference in use",String.valueOf(this.getDirRef()),Describer.describeDirRef(this.getDirRef()));
        ct.addRow("Current Speed", this.getCurrentSpeedKnots(),"Knots");
        ct.addRow("Reference Layer Depth", this.getRefLayerDepthMeters() ,"Meters");
        ct.addRow("Heading",this.getHeading() ,Describer.describeMagnetic(this.getHeadingRef()));
        ct.addRow("Speed Reference",String.valueOf(this.getSpeedChar()), Describer.describeSpeedReference(this.getSpeedChar()));
        ct.print();
    }
}
