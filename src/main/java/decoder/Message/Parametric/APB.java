package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class APB {
    public APB(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: APB");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setStatus1(s[1].charAt(0));
            setStatus2(s[2].charAt(0));
            setMagOfXTE(s[3]);
            setDirSteer(s[4].charAt(0));
            setXTEunit(s[5].charAt(0));
            setStatus3(s[6].charAt(0));
            setStatus4(s[7].charAt(0));
            setBearingOriginToDestination(s[8]);
            setMagneticOD(s[9].charAt(0));
            setDestinationID(s[10]);
            setBearingPositionToDestination(s[11]);
            setMagneticPD(s[12].charAt(0));
            setHeadingToSteerToDestination(s[13]);
            setMagneticHD(s[14].charAt(0));
            setModeIndicator(s[15].charAt(0));
        }catch (Exception e){
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }
    public char getStatus1() {
        return status1;
    }
    public void setStatus1(char status1) {
        this.status1 = status1;
    }
    public char getStatus2() {
        return status2;
    }
    public void setStatus2(char status2) {
        this.status2 = status2;
    }
    public String getMagOfXTE() {
        return magOfXTE;
    }
    public void setMagOfXTE(String magOfXTE) {
        this.magOfXTE = magOfXTE;
    }
    public char getDirSteer() {
        return dirSteer;
    }
    public void setDirSteer(char dirSteer) {
        this.dirSteer = dirSteer;
    }
    public char getXTEunit() {
        return XTEunit;
    }
    public void setXTEunit(char XTEunit) {
        this.XTEunit = XTEunit;
    }
    public char getStatus3() {
        return status3;
    }
    public void setStatus3(char status3) {
        this.status3 = status3;
    }
    public char getStatus4() {
        return status4;
    }
    public void setStatus4(char status4) {
        this.status4 = status4;
    }
    public String getBearingOriginToDestination() {
        return bearingOriginToDestination;
    }
    public void setBearingOriginToDestination(String bearingOriginToDestination) {
        this.bearingOriginToDestination = bearingOriginToDestination;
    }
    public char getMagneticOD() {
        return magneticOD;
    }
    public void setMagneticOD(char magneticOD) {
        this.magneticOD = magneticOD;
    }
    public String getDestinationID() {
        return destinationID;
    }
    public void setDestinationID(String destinationID) {
        this.destinationID = destinationID;
    }
    public String getBearingPositionToDestination() {
        return bearingPositionToDestination;
    }
    public void setBearingPositionToDestination(String bearingPositionToDestination) {
        this.bearingPositionToDestination = bearingPositionToDestination;
    }
    public char getMagneticPD() {
        return magneticPD;
    }
    public void setMagneticPD(char magneticPD) {
        this.magneticPD = magneticPD;
    }
    public String getHeadingToSteerToDestination() {
        return headingToSteerToDestination;
    }
    public void setHeadingToSteerToDestination(String headingToSteerToDestination) {
        this.headingToSteerToDestination = headingToSteerToDestination;
    }
    public char getMagneticHD() {
        return magneticHD;
    }
    public void setMagneticHD(char magneticHD) {
        this.magneticHD = magneticHD;
    }
    public char getModeIndicator() {
        return modeIndicator;
    }
    public void setModeIndicator(char modeIndicator) {
        this.modeIndicator = modeIndicator;
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
    private char status1;
    private char status2;
    private String magOfXTE;
    private char dirSteer;
    private char XTEunit;
    private char status3;
    private char status4;
    private String bearingOriginToDestination;
    private char magneticOD;
    private String destinationID;
    private String bearingPositionToDestination;
    private char magneticPD;
    private String headingToSteerToDestination;
    private char magneticHD;
    private char modeIndicator;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tStatus: " + this.getStatus1()+ "\n");
        builder.append("\tStatus: " + this.getStatus2()+ "\n");
        builder.append("\tMagnitudeOfXTE: " + this.getMagOfXTE()+ "\n");
        builder.append("\tDirectionOfSteer: " + this.getDirSteer() + "\n");
        builder.append("\tXTEUnit: " + this.getXTEunit() + "\n");
        builder.append("\tStatus: " + this.getStatus3() + "\n");
        builder.append("\tStatus: " + this.getStatus4()+ "\n");
        builder.append("\tBearingOriginToDestination: " + this.getBearingOriginToDestination()+ " " + this.getMagneticOD() + "\n");
        builder.append("\tDestinationWaypointID: " + this.getDestinationID() + "\n");
        builder.append("\tBearingPresentPositionToDestination: " + this.getBearingPositionToDestination() + " " +this.getMagneticPD()+ "\n");
        builder.append("\tHeadingToSteerToDestination: " + this.getHeadingToSteerToDestination() + " " + this.getMagneticHD()+ "\n");
        builder.append("\tModeIndicator" + this.getModeIndicator() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Status", String.valueOf(this.getStatus1()), Describer.describeData(this.getStatus1()));
        ct.addRow("Status", String.valueOf(this.getStatus2()) ,Describer.describeCycleLock(this.getStatus2()));
        ct.addRow("Cross Track Error Magnitude", this.getMagOfXTE(),"");
        ct.addRow("Direction Of Steer", String.valueOf(this.getDirSteer()) ,Describer.describeSteer(this.getDirSteer()));
        ct.addRow("Cross Track Units", String.valueOf(this.getXTEunit()) ,"Nautical Miles");
        ct.addRow("Status", String.valueOf(this.getStatus3()),Describer.describeArrival(this.getStatus3()));
        ct.addRow("Status", String.valueOf(this.getStatus4()),Describer.describePerpendicular(this.getStatus4()));
        ct.addRow("Bearing Origin To Destination", this.getBearingOriginToDestination() ,Describer.describeMagnetic(this.getMagneticOD()));
        ct.addRow("Destination Waypoint ID", this.getDestinationID() ,"");
        ct.addRow("Bearing, Present Position to Destination", this.getBearingPositionToDestination(), Describer.describeMagnetic(this.getMagneticPD()));
        ct.addRow("Heading to Steer to Destination waypoint", this.getHeadingToSteerToDestination(), Describer.describeMagnetic(this.getMagneticHD()));
        ct.addRow("Mode Indicator", String.valueOf(this.getModeIndicator()), Describer.describePosMode(this.getModeIndicator()));
        ct.print();
    }
}
