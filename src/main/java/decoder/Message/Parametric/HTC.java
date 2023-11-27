package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class HTC {
    public HTC(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: HTC");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setOverride(s[1]);
            setCommandedRudderAngle(s[2]);
            setCommandedRudderDirection(s[3]);
            setSelectedSteeringMode(s[4]);
            setTurnMode(s[5]);
            setCommandedRudderLimit(s[6]);
            setCommandedOffHeadingLimit(s[7]);
            setCommandedRadiusOfTurn(s[8]);
            setCommandedRateOfTurn(s[9]);
            setCommandedHeadingToSteer(s[10]);
            setCommandedOffTrackLimit(s[11]);
            setCommandedTrack(s[12]);
            if(this.getFormat().equals("HTC")){
                setHeadingRef(s[13].split("\\*")[0]);
                setRudderStatus("");
                setOffHeadingStatus("");
                setOffTrackStatus("");
                setVesselHeading("");
            }else {
                setHeadingRef(s[13]);
                setRudderStatus(s[14]);
                setOffHeadingStatus(s[15]);
                setOffTrackStatus(s[16]);
                setVesselHeading(s[17].split("\\*")[0]);
            }
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
    private String override;
    private String commandedRudderAngle;
    private String commandedRudderDirection;
    private String selectedSteeringMode;
    private String turnMode;
    private String commandedRudderLimit;
    private String commandedOffHeadingLimit;
    private String commandedRadiusOfTurn;
    private String commandedRateOfTurn;
    private String commandedHeadingToSteer;
    private String commandedOffTrackLimit;

    public String getOverride() {
        return override;
    }

    public void setOverride(String override) {
        this.override = override;
    }

    public String getCommandedRudderAngle() {
        return commandedRudderAngle;
    }

    public void setCommandedRudderAngle(String commandedRudderAngle) {
        this.commandedRudderAngle = commandedRudderAngle;
    }

    public String getCommandedRudderDirection() {
        return commandedRudderDirection;
    }

    public void setCommandedRudderDirection(String commandedRudderDirection) {
        this.commandedRudderDirection = commandedRudderDirection;
    }

    public String getSelectedSteeringMode() {
        return selectedSteeringMode;
    }

    public void setSelectedSteeringMode(String selectedSteeringMode) {
        this.selectedSteeringMode = selectedSteeringMode;
    }

    public String getTurnMode() {
        return turnMode;
    }

    public void setTurnMode(String turnMode) {
        this.turnMode = turnMode;
    }

    public String getCommandedRudderLimit() {
        return commandedRudderLimit;
    }

    public void setCommandedRudderLimit(String commandedRudderLimit) {
        this.commandedRudderLimit = commandedRudderLimit;
    }

    public String getCommandedOffHeadingLimit() {
        return commandedOffHeadingLimit;
    }

    public void setCommandedOffHeadingLimit(String commandedOffHeadingLimit) {
        this.commandedOffHeadingLimit = commandedOffHeadingLimit;
    }

    public String getCommandedRadiusOfTurn() {
        return commandedRadiusOfTurn;
    }

    public void setCommandedRadiusOfTurn(String commandedRadiusOfTurn) {
        this.commandedRadiusOfTurn = commandedRadiusOfTurn;
    }

    public String getCommandedRateOfTurn() {
        return commandedRateOfTurn;
    }

    public void setCommandedRateOfTurn(String commandedRateOfTurn) {
        this.commandedRateOfTurn = commandedRateOfTurn;
    }

    public String getCommandedHeadingToSteer() {
        return commandedHeadingToSteer;
    }

    public void setCommandedHeadingToSteer(String commandedHeadingToSteer) {
        this.commandedHeadingToSteer = commandedHeadingToSteer;
    }

    public String getCommandedOffTrackLimit() {
        return commandedOffTrackLimit;
    }

    public void setCommandedOffTrackLimit(String commandedOffTrackLimit) {
        this.commandedOffTrackLimit = commandedOffTrackLimit;
    }

    public String getCommandedTrack() {
        return commandedTrack;
    }

    public void setCommandedTrack(String commandedTrack) {
        this.commandedTrack = commandedTrack;
    }

    public String getHeadingRef() {
        return headingRef;
    }

    public void setHeadingRef(String headingRef) {
        this.headingRef = headingRef;
    }

    public String getRudderStatus() {
        return rudderStatus;
    }

    public void setRudderStatus(String rudderStatus) {
        this.rudderStatus = rudderStatus;
    }

    public String getOffHeadingStatus() {
        return offHeadingStatus;
    }

    public void setOffHeadingStatus(String offHeadingStatus) {
        this.offHeadingStatus = offHeadingStatus;
    }

    public String getOffTrackStatus() {
        return offTrackStatus;
    }

    public void setOffTrackStatus(String offTrackStatus) {
        this.offTrackStatus = offTrackStatus;
    }

    public String getVesselHeading() {
        return vesselHeading;
    }

    public void setVesselHeading(String vesselHeading) {
        this.vesselHeading = vesselHeading;
    }

    private String commandedTrack;
    private String headingRef;
    private String rudderStatus;
    private String offHeadingStatus;
    private String offTrackStatus;
    private String vesselHeading;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tOverride: " + this.getOverride() + "\n");
        builder.append("\tCommandedRudderAngle: " + this.getCommandedRudderAngle() + "\n");
        builder.append("\tCommandedRudderDirection: " + this.getCommandedRudderDirection() + "\n");
        builder.append("\tSelectedSteeringMode: " + this.getSelectedSteeringMode() + "\n");
        builder.append("\tTurnMode: " + this.getTurnMode()+ "\n");
        builder.append("\tCommandedRudderLimit: " + this.getCommandedRudderLimit() + "\n");
        builder.append("\tCommandedOffHeadingLimit: " + this.getCommandedOffHeadingLimit() + "\n");
        builder.append("\tCommandedRadiusOfTurn: " + this.getCommandedRadiusOfTurn() + "\n");
        builder.append("\tCommandedRateOfTurn: " + this.getCommandedRateOfTurn() + "\n");
        builder.append("\tCommandedHeadingToSteer: " + this.getCommandedHeadingToSteer() + "\n");
        builder.append("\tCommandedOffTrackLimit: " + this.getCommandedOffTrackLimit() + "\n");
        builder.append("\tCommandedTrack: " + this.getCommandedTrack() + "\n");
        builder.append("\tHeadingReferenceInUse: " + this.getHeadingRef() + "\n");
        builder.append("\tRudderStatus: " + this.getRudderStatus() + "\n");
        builder.append("\tOffHeadingStatus: " + this.getOffHeadingStatus() + "\n");
        builder.append("\tOffTrackStatus: " + this.getOffTrackStatus() + "\n");
        builder.append("\tVesselHeading: " + this.getVesselHeading() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Override", this.getOverride() , Describer.describeOverride(this.getOverride()));
        ct.addRow("Commanded rudder angle", this.getCommandedRudderAngle(), "degrees");
        ct.addRow("Commanded rudder direction", this.getCommandedRudderDirection(), Describer.describeHTCDir(this.getCommandedRudderDirection()));
        ct.addRow("Selected steering mode", this.getSelectedSteeringMode(), Describer.describeHTCSteer(this.getSelectedSteeringMode()));
        ct.addRow("Turn mode", this.getTurnMode(), Describer.describeHTCTurnMode(this.getTurnMode()));
        ct.addRow("Commanded rudder limit", this.getCommandedRudderLimit(), "degrees (unsigned)");
        ct.addRow("Commanded off-heading limit", this.getCommandedOffHeadingLimit() , "degrees (unsigned)");
        ct.addRow("Commanded radius of turn for heading changes", this.getCommandedRadiusOfTurn(), "Nautical miles");
        ct.addRow("Commanded rate of turn for heading changes", this.getCommandedRateOfTurn(), "degrees/minute");
        ct.addRow("Commanded heading-to-steer", this.getCommandedHeadingToSteer(), "degrees");
        ct.addRow("Commanded off-track limit", this.getCommandedOffTrackLimit(), "Nautical miles (unsigned)");
        ct.addRow("Commanded track", this.getCommandedTrack(), "degrees");
        ct.addRow("Heading Reference in use", this.getHeadingRef(), Describer.describeMagnetic(this.getHeadingRef().charAt(0)));
        ct.addRow("Rudder status", this.getRudderStatus(), Describer.describeHTCStatus(this.getRudderStatus()));
        ct.addRow("Off-heading status", this.getOffHeadingStatus(), Describer.describeHTCStatus(this.getOffHeadingStatus()));
        ct.addRow("Off-track status", this.getOffTrackStatus(), Describer.describeHTCStatus(this.getOffTrackStatus()));
        ct.addRow("Vessel heading", this.getVesselHeading(), "degrees");
        ct.print();
    }
}
