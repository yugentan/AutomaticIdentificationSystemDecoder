package decoder.Message.Types;

import decoder.Binary.Binary;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
import decoder.Communication.CommunicationState;
import decoder.Message.Encapsulated.Emessage;

public class Message18 extends Emessage{
    public Message18(){};
    public void run(Emessage e){
        setBitmap(e.getBitmap());
        this.setCommonField(e);
        this.assignFields();
    }
    public void json(){
        System.out.println(this.toJson());
    }
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: BOD");
        }
    };    public void setCommonField(Emessage e){
        this.setRepeater(e.getRepeater());
        this.setMsgId(e.getMsgId());
        this.setMMSI(e.getMMSI());
    }
    private void assignFields(){
        this.assignSpare();
        this.assignPosAcc();
        this.assignSOG();
        this.assignCOG();
        this.assignLongitude();
        this.assignLatitude();
        this.assignTrueHeading();
        this.assignTimeStamp();
        this.assignSpare2();
        this.assignUnitFlag();
        this.assignDSCFlag();
        this.assignDisplayFlag();
        this.assignBandFlag();
        this.assignM22Flag();
        this.assignModeFlag();
        this.assignRaim();
        this.assignCommsSelector();
        this.assignCommsState();
    }
    private void assignSpare(){
        String spareString = "";
        try{
            for(int i = 0; i < spareCount; i++){
                spareString += bitmap.toCharArray()[i + sparePtr];
            }
            setSpare(Binary.convertToDec(spareString));
        }catch (Exception e){
            setSpare(0);
        }
    }
    private void assignPosAcc(){
        String posAccString = "";
        try{
            for(int i = 0; i < posAccCount; i++){
                posAccString += bitmap.toCharArray()[i + posAccPtr];
            }
            setPosAcc(Binary.convertToDec(posAccString));
        }catch (Exception e){
            setPosAcc(0);
        }
    }
    private void assignSOG(){
        String SOGString = "";
        try{
            for(int i = 0; i < sogCount; i++){
                SOGString += bitmap.toCharArray()[i + sogPtr];
            }
            setSOG(Binary.getSOG(Binary.convertToDec(SOGString)));
        }catch (Exception e){
            setSOG(Binary.getSOG(1023));
        }
    }
    private void assignCOG(){
        String cogString = "";
        try{
            for(int i = 0; i < cogCount; i++){
                cogString += bitmap.toCharArray()[i + cogPtr];
            }
            setCog(Binary.getCOG(Binary.convertToDec(cogString)));
        }catch (Exception e){
            setCog(3600.00f);
        }
    }
    private void assignLongitude(){
        String longitudeString = "";
        try{
            for(int i = 0; i < longCount; i++){
                longitudeString += bitmap.toCharArray()[i + longPtr];
            }
            setLon(Binary.decToLong(Binary.convertToDec(Binary.printOneAndTwosComplement(longitudeString)), longitudeString.toCharArray()[0]));
        }catch (Exception e){
            setLon("Not available");
        }

    }
    private void assignLatitude(){
        String latitudeString = "";
        try{
            for(int i = 0; i < latCount; i++){
                latitudeString += bitmap.toCharArray()[i + latPtr];
            }
            setLat(Binary.decToLat(Binary.convertToDec(Binary.printOneAndTwosComplement(latitudeString)),latitudeString.toCharArray()[0]));
        }catch (Exception e){
            setLat("Not available");
        }
    }
    private void assignTrueHeading(){
        String trueHeadingString = "";
        try{
            for(int i = 0; i < trueHeadingCount; i++){
                trueHeadingString += bitmap.toCharArray()[i + trueHeadingPtr];
            }
            setTrueHeading(Binary.convertToDec(trueHeadingString));
        }catch (Exception e){
            setTrueHeading(511);
        }
    }
    private void assignTimeStamp(){
        String timeStampString = "";
        try{
            for(int i = 0; i < timeStampCount; i++){
                timeStampString += bitmap.toCharArray()[i + timeStampPtr];
            }
            setTimeStamp(Binary.convertToDec(timeStampString));
        }catch (Exception e){
            setTimeStamp(60);
        }
    }
    private void assignSpare2(){
        String spare2String = "";
        try{
            for(int i = 0; i < spare2Count; i++){
                spare2String += bitmap.toCharArray()[i + spare2Ptr];
            }
            setSpare2(Binary.convertToDec(spare2String));
        }catch (Exception e){
            setSpare2(0);
        }
    }
    private void assignUnitFlag(){
        String unitFlagString = "";
        try {
            for(int i = 0; i < classBUnitFlagCount; i++){
                unitFlagString += bitmap.toCharArray()[i + classBUnitFlagPtr];
            }
            setUnitFlag(Binary.convertToDec(unitFlagString));
        }catch (Exception e){
            setUnitFlag(0);
        }
    }
    private void assignDSCFlag(){
        String dscString = "";
        try {
            for (int i = 0; i < classBDSCFlagCount; i++){
                dscString += bitmap.toCharArray()[i + classBDSCFlagPtr];
            }
            setDscFlag(Binary.convertToDec(dscString));
        }catch (Exception e){
            setDscFlag(0);
        }
    }
    private void assignDisplayFlag(){
        String displayString = "";
        try{
            for (int i = 0; i < classBDisplayFlagCount; i ++){
                displayString += bitmap.toCharArray()[i + classBDisplayFlagPtr];
            }
            setDisplayFlag(Binary.convertToDec(displayString));
        }catch (Exception e){
            setDisplayFlag(0);
        }
    }
    private void assignBandFlag(){
        String bandString = "";
        try {
            for (int i = 0; i < classBBandFlagCount; i++) {
                bandString += bitmap.toCharArray()[i + classBBandFlagPtr];
            }
            setBandFlag(Binary.convertToDec(bandString));
        }catch (Exception e){
            setBandFlag(0);
        }
    }
    private void assignM22Flag(){
        String m22String = "";
        try{
            for(int i = 0; i < classBM22FlagCount; i++){
                m22String += bitmap.toCharArray()[i + classBM22FlagPtr];
            }
            setM22Flag(Binary.convertToDec(m22String));
        }catch (Exception e){
            setM22Flag(0);
        }
    }
    private void assignModeFlag(){
        String modeString = "";
        try{
            for(int i = 0; i < modeFlagCount; i++){
                modeString += bitmap.toCharArray()[i + modeFlagPtr];
            }
            setModeFlag(Binary.convertToDec(modeString));
        }catch (Exception e){
            setModeFlag(0);
        }
    }
    private void assignRaim(){
        String raimString = "";
        try{
            for(int i = 0; i < raimCount; i++){
                raimString += bitmap.toCharArray()[i + raimPtr];
            }
            setRaim(Binary.convertToDec(raimString));
        }catch (Exception e){
            setRaim(0);
        }
    }
    private void assignCommsSelector(){
        String commsSelectorString = "";
        try{
            for(int i = 0; i < commsSelectorCount; i++){
                commsSelectorString += bitmap.toCharArray()[i + commsSelectorPtr];
            }
            setCommmsSelector(Binary.convertToDec(commsSelectorString));
            if(Binary.convertToDec(commsSelectorString) == 0){
                cs.setCsState(true);
            }else{
                cs.setCsState(false);
            }
        }catch (Exception e){
            setCommmsSelector(0); //sotdma
        }
    }
    private void assignCommsState(){
        String communicationString = "";
        try{
            for(int i = 0; i < commsStateCount; i++){
                communicationString += bitmap.toCharArray()[i + commsStatePtr];
            }
            setCommunicationState(Binary.convertToDec(communicationString));
            cs.parseCommunicationString(communicationString);
        }catch (Exception e){
            setCommunicationState(0);
        }
    }
    /** Setters*/
    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }
    public void setSpare(int _i){
        this.spare = _i;
    }
    public void setPosAcc(int _i){
        this.posAcc = _i;
    }
    public void setSOG(Float _f){
        this.sog = _f;
    }
    public void setCog(Float _f){
        this.cog = _f;
    }
    public void setLon(String _s){
        this.longitude = _s;
    }
    public void setLat(String _s){
        this.latitude = _s;
    }
    public void setTrueHeading(int _i){
        this.trueHeading = _i;
    }
    public void setTimeStamp(int _i){
        this.timeStamp = _i;
    }
    public void setSpare2(int _i){
        this.spare2 = _i;
    }
    public void setUnitFlag(int _i){
        this.unitFlag = _i;
    }
    public void setDscFlag(int _i){
        this.dscFlag = _i;
    }
    public void setDisplayFlag(int _i){
        this.displayFlag = _i;
    }
    public void setBandFlag(int _i){
        this.bandFlag = _i;
    }
    public void setM22Flag(int _i){
        this.m22Flag = _i;
    }
    public void setModeFlag(int _i){
        this.modeFlag = _i;
    }
    public void setRaim(int _i){
        this.raim = _i;
    }
    public void setCommmsSelector(int _i){
        this.commSelector = _i;
    }
    public void setCommunicationState(int _i){
        this.commState = _i;
    }
    /** Getters*/
    public String getBitMap(){
        return this.bitmap;
    }
    public int getSpare(){
        return this.spare;
    }
    public int getPosAcc(){
        return this.posAcc;
    }
    public Float getSOG(){
        return this.sog;
    }
    public Float getCog(){
        return this.cog;
    }
    public String getLon() {
        return this.longitude;
    }
    public String getLat() {
        return this.latitude;
    }
    public int getTrueHeading(){
        return this.trueHeading;
    }
    public int getTimeStamp(){
        return this.timeStamp;
    }
    public int getSpare2(){
        return this.spare2;
    }
    public int getUnitFlag(){
        return this.unitFlag;
    }
    public int getDscFlag(){
        return this.dscFlag;
    }
    public int getDisplayFlag(){
        return this.displayFlag;
    }
    public int getBandFlag(){
        return this.bandFlag;
    }
    public int getM22Flag(){
        return this.m22Flag;
    }
    public int getModeFlag(){
        return this.modeFlag;
    }
    public int getRaim(){
        return this.raim;
    }
    public int getCommsSelector(){
        return this.commSelector;
    }
    public int getCommunicationState(){
        return this.commState;
    }
    private int spare;
    private int posAcc;
    private Float sog;
    private String longitude;
    private String latitude;
    private Float cog;
    private int trueHeading;
    private int timeStamp;
    private int spare2;
    private int unitFlag;
    private int dscFlag;
    private int displayFlag;
    private int bandFlag;
    private int m22Flag;
    private int modeFlag;
    private int raim;
    private int commSelector;
    private int commState;
    private String bitmap = "";
    private CommunicationState cs = new CommunicationState();
    final int sparePtr = 38, spareCount = 8;
    final int sogPtr = 46, sogCount = 10;
    final int posAccPtr = 56, posAccCount = 1;
    final int longPtr = 57, longCount = 28;
    final int latPtr = 85, latCount = 27;
    final int cogPtr = 112, cogCount = 12;
    final int trueHeadingPtr = 124, trueHeadingCount = 9;
    final int timeStampPtr = 133, timeStampCount = 6;
    final int spare2Ptr = 139, spare2Count = 2;
    final int classBUnitFlagPtr = 141, classBUnitFlagCount = 1;
    final int classBDisplayFlagPtr = 142, classBDisplayFlagCount = 1;
    final int classBDSCFlagPtr = 143, classBDSCFlagCount = 1;
    final int classBBandFlagPtr = 144, classBBandFlagCount = 1;
    final int classBM22FlagPtr = 145, classBM22FlagCount = 1;
    final int modeFlagPtr = 146, modeFlagCount = 1;
    final int raimPtr = 147, raimCount = 1;
    final int commsSelectorPtr = 148, commsSelectorCount = 1;
    final int commsStatePtr = 149, commsStateCount = 19;
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tMessageID: " + this.getMsgId() + "\n");
        builder.append("\tRepeater: " + this.getRepeater() + "\n");
        builder.append("\tMMSI: " + this.getMMSI() + "\n");
        builder.append("\tSpare: " + this.getSpare() + "\n");
        builder.append("\tSOG: " + this.getSOG() + "\n");
        builder.append("\tPositionAccuracy: " + this.getPosAcc() + "\n");
        builder.append("\tLongitude: " + this.getLon() + "\n");
        builder.append("\tLatitude: " + this.getLat() + "\n");
        builder.append("\tCOG: " + this.getCog() + "\n");
        builder.append("\tTrueHeading: " + this.getTrueHeading() + "\n");
        builder.append("\tTimeStamp: " + this.getTimeStamp() + "\n");
        builder.append("\tSpare2: " + this.getSpare2() + "\n");
        builder.append("\tClassBUnitFlag: " + this.getUnitFlag() + "\n");
        builder.append("\tClassBDisplayFlag: " + this.getDisplayFlag() + "\n");
        builder.append("\tClassBDSCFlag: " + this.getDscFlag() + "\n");
        builder.append("\tClassBBandFlag: " + this.getBandFlag() + "\n");
        builder.append("\tClassBMessage22Flag: " + this.getM22Flag() + "\n");
        builder.append("\tModeFlag: " + this.getModeFlag() + "\n");
        builder.append("\tRaimFlag: " + this.getRaim() + "\n");
        builder.append("\tCommunicationSelector: " + this.getCommsSelector() + "\n");
        builder.append("\tCommunicationState: " + this.getCommunicationState() + "\n");
        builder.append("\tSyncState: " + cs.getSyncState() + "\n");
        if(cs.getCsState()) {
            builder.append("\tSlotTimeout: " + cs.getSlotTimeOut() + "\n");
            builder.append("\tCommunicationSubMessage: " + cs.getSubMessageInt() + "\n");
            builder.append("\tSubMessage: " + cs.getSubMessage() + "\n");
            builder.append("\tCommunicationSlotNumber: " + cs.getCommunicationSlotNumber() + "\n");
            builder.append("\tReceivedStation: " + cs.getReceivedStation() + "\n");
            builder.append("\tCommunicationSlotOffset: " + cs.getCommunicationSlotOffset() + "\n");
        }else{
            builder.append("\tSlotIncrement: " + cs.getSlotIncrement() + "\n");
            builder.append("\tNumberOfSlots: " + cs.getNumberOfSlots() + "\n");
            builder.append("\tKeepFlag: " + cs.getKeepFlag() + "\n");
        }
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Message ID", String.valueOf(this.getMsgId()), Describer.describeMessageType(this.getMsgId()));
        ct.addRow("Repeater", String.valueOf(this.getRepeater()),  Describer.describeRepeater(this.getRepeater()));
        ct.addRow("User ID (MMSI)", String.valueOf(this.getMMSI()), "");
        ct.addRow("Spare", String.valueOf(this.getSpare2()), Describer.describeSpare(this.getSpare2()));
        ct.addRow("Speed Over Ground", String.valueOf(this.getSOG()), "");
        ct.addRow("Position Accuracy", String.valueOf(this.getPosAcc()), Describer.describePosAcc(this.getPosAcc()));
        ct.addRow("Longitude", String.valueOf(this.getLon()), "");
        ct.addRow("Latitude", String.valueOf(this.getLat()), "");
        ct.addRow("Course Over Ground", String.valueOf(this.getCog()), "");
        ct.addRow("True Heading", String.valueOf(this.getTrueHeading()), "");
        ct.addRow("Time Stamp", String.valueOf(this.getTimeStamp()), Describer.describeTimeStamp(this.getTimeStamp()));
        ct.addRow("Spare", String.valueOf(this.getSpare2()), Describer.describeSpare(this.getSpare2()));
        ct.addRow("Class B Unit Flag", String.valueOf(this.getUnitFlag()), Describer.describeUnitFlag(this.getUnitFlag()));
        ct.addRow("Class B Display Flag", String.valueOf(this.getDisplayFlag()), Describer.describeDisplayFlag(this.getDisplayFlag()));
        ct.addRow("Class B DSC Flag", String.valueOf(this.getDscFlag()), Describer.describeDSCFlag(this.getDscFlag()));
        ct.addRow("Class B Band Flag", String.valueOf(this.getBandFlag()), Describer.describeBandFlag(this.getBandFlag()));
        ct.addRow("Class B Message 22 Flag", String.valueOf(this.getM22Flag()), Describer.describeM22Flag(this.getM22Flag()));
        ct.addRow("Mode Flag", String.valueOf(this.getModeFlag()), Describer.describeModeFlag(this.getModeFlag()));
        ct.addRow("RAIM Flag", String.valueOf(this.getRaim()), Describer.describeRaim(this.getRaim()));
        ct.addRow("Communication Selector", String.valueOf(this.getCommsSelector()), Describer.describeCommsSelector(this.getCommsSelector()));
        ct.addRow("Communication State", String.valueOf(this.getCommunicationState()), "");
        ct.addRow("Sync State", String.valueOf(cs.getSyncState()), Describer.describeSyncState(cs.getSyncState()));
        if(cs.getCsState()){
            ct.addRow("Slot Timeout", String.valueOf(cs.getSlotTimeOut()), Describer.describeSlotTimeOut(cs.getSlotTimeOut()));
            ct.addRow("Communication Sub Message", String.valueOf(cs.getSubMessageInt()),"");
            ct.addRow("Sub Message", cs.getSubMessage(),"");
            ct.addRow("Communication Slot Number",String.valueOf(cs.getCommunicationSlotNumber()),"");
            ct.addRow("Received Station",String.valueOf(cs.getReceivedStation()),"");
            ct.addRow("Communication Slot Offset", String.valueOf(cs.getCommunicationSlotOffset()), "");
        }else{
            ct.addRow("Slot Increment", String.valueOf(cs.getSlotIncrement()), "");
            ct.addRow("Number of Slots", String.valueOf(cs.getNumberOfSlots()), Describer.describeNumberOfSlot(cs.getNumberOfSlots()));
            ct.addRow("Keep Flag", String.valueOf(cs.getKeepFlag()),"");
        }
        ct.print();
    }
}
