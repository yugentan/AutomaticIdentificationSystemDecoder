package decoder.Message.Types;

import decoder.Binary.Binary;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
import decoder.Communication.CommunicationState;
import decoder.Message.Encapsulated.Emessage;

public class Message123 extends Emessage {
    public Message123(){}
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
    };    /** Getters */
    public int getNavStatus(){
        return this.navStatus;
    }
    public Float getROT(){
        return this.rateOfTurn;
    }
    public Float getSOG(){
        return this.speedOverGround;
    }
    public String getLong(){
        return this.longitude;
    }
    public String getLat(){
        return this.latitude;
    }
    public int getPosAcc(){
        return this.posAcc;
    }
    public Float getCog(){
        return this.cog;
    }
    public int getTrueHeading(){
        return this.trueHeading;
    }
    public int getTimeStamp(){
        return this.timeStamp;
    }
    public int getSpecialManoeuvre(){
        return this.specialManoeuvre;
    }
    public int getSpare(){
        return this.spare;
    }
    public int getRaim(){
        return this.raim;
    }
    public int getCommunicationState(){
        return this.communicationState;
    }
    public int getBitfill(){
        return bitfill;
    }

    /** Setters*/
    public void setNavStatus(int _i){
        this.navStatus = _i;
    }
    public void setROT(Float f){
        this.rateOfTurn = f;
    }
    public void setSOG(Float f){
        this.speedOverGround = f;
    }
    public void setLon(String s){
        this.longitude = s;
    }
    public void setLat(String s){
        this.latitude = s;
    }
    public void setPosAcc(int _i) {
        this.posAcc = _i;
    }
    public void setCog(Float f){
        this.cog = f;
    }
    public void setTrueHeading(int i){
        this.trueHeading = i;
    }
    public void setTimeStamp(int i){
        this.timeStamp = i;
    }
    public void setSpecialManoeuvre(int _i){
        this.specialManoeuvre = _i;
    }
    public void setSpare(int i){
        this.spare = i;
    }
    public void setRaim(int _i){
        this.raim = _i;
    }
    public void setCommunicationState(int i){
        this.communicationState = i;
    }
    public void setBitfill(int i){
        this.bitfill = i;
    }
    public void setCommonField(Emessage e){
        this.setRepeater(e.getRepeater());
        this.setMsgId(e.getMsgId());
        this.setMMSI(e.getMMSI());
    }
    private void assignFields(){
        this.assignNavStatus();
        this.assignRot();
        this.assignSOG();
        this.assignPosAcc();
        this.assignLongitude();
        this.assignLatitude();
        this.assignCOG();
        this.assignTrueHeading();
        this.assignTimeStamp();
        this.assignSpecialManoeuvre();
        this.assignSpare();
        this.assignRaim();
        this.assignCommunication();
    }
    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }
    public String getBitMap(){
        return this.bitmap;
    }
    private void assignNavStatus(){
        String navString = "";
        try{
            for(int i = 0; i < navStatusCount; i++){
                navString += bitmap.toCharArray()[i + navStatusPtr];
            }
            setNavStatus(Binary.convertToDec(navString));
        }catch (Exception e){
            setNavStatus(15);
        }
    }
    private void assignRot(){
        String rotString = "";
        try{
            for(int i = 0; i < rotCount; i++){
                rotString += bitmap.toCharArray()[i + rotPtr];
            }
            setROT(Binary.getSensorRot(Binary.convertToDec(rotString)));
        }catch (Exception e){
            setROT(Binary.getSensorRot(-128));
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
    private void assignSpecialManoeuvre(){
        String specialManoeuvreString = "";
        try{
            for(int i = 0; i < specialManoeuvreCount; i++){
                specialManoeuvreString += bitmap.toCharArray()[i + specialManoeuvrePtr];
            }
            setSpecialManoeuvre(Binary.convertToDec(specialManoeuvreString));
        }catch (Exception e){
            setSpecialManoeuvre(0);
        }

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
    private void assignCommunication(){
        String communicationString = "";
        try{
            for(int i = 0; i < commStateCount; i++){
                communicationString += bitmap.toCharArray()[i + commStatePtr];
            }
            setCommunicationState(Binary.convertToDec(communicationString));
            cs.setCsState(true);
            cs.parseCommunicationString(communicationString);
        }catch (Exception e){
            setCommunicationState(0);
        }

    }



    private int navStatus;
    private Float rateOfTurn;
    private Float speedOverGround;
    private int posAcc;
    private String longitude;
    private String latitude;
    private Float cog;
    private int trueHeading;
    private int timeStamp;
    private int specialManoeuvre;
    private int spare;
    private int raim;
    private int communicationState;
    private int bitfill;
    final static int navStatusPtr = 38, navStatusCount = 4;
    final static int rotPtr = 42, rotCount = 8;
    final static int sogPtr = 50, sogCount = 10;
    final static int posAccPtr = 60, posAccCount = 1;
    final static int longPtr = 61, longCount = 28;
    final static int latPtr = 89, latCount = 27;
    final static int cogPtr = 116, cogCount = 12;
    final static int trueHeadingPtr = 128, trueHeadingCount = 9;
    final static int timeStampPtr = 137, timeStampCount = 6;
    final static int specialManoeuvrePtr = 143, specialManoeuvreCount = 4;
    final static int sparePtr = 147, spareCount = 1;
    final static int raimPtr = 148, raimCount = 1;
    final static int commStatePtr = 149, commStateCount = 19;
    private String bitmap = "";
    private CommunicationState cs = new CommunicationState();
    public String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tMessageID: " + this.getMsgId() + "\n");
        builder.append("\tRepeater: " + this.getRepeater() + "\n");
        builder.append("\tMMSI: " + this.getMMSI() + "\n");
        builder.append("\tNavigationStatus: " + this.getNavStatus() + "\n");
        builder.append("\tRateOfTurn: " + this.getROT() + "\n");
        builder.append("\tSOG: " + this.getSOG() + "\n");
        builder.append("\tPositionAccuracy: " + this.getPosAcc() + "\n");
        builder.append("\tLongitude: " + this.getLong() + "\n");
        builder.append("\tLatitude: " + this.getLat() + "\n");
        builder.append("\tCOG: " + this.getCog() + "\n");
        builder.append("\tTrueHeading: " + this.getTrueHeading() + "\n");
        builder.append("\tTimeStamp: " + this.getTimeStamp() + "\n");
        builder.append("\tSpecialManoeuvreIndex: " + this.getSpecialManoeuvre() + "\n");
        builder.append("\tSpare: " + this.getSpare() + "\n");
        builder.append("\tRaimFlag: " + this.getRaim() + "\n");
        builder.append("\tCommunicationState: " + this.getCommunicationState() + "\n");
        builder.append("\tSyncState: " + cs.getSyncState() + "\n");
        builder.append("\tSlotTimeout: " + cs.getSlotTimeOut() + "\n");
        builder.append("\tCommunicationSubMessage: " + cs.getSubMessageInt() + "\n");
        builder.append("\tSubMessage: " + cs.getSubMessage()+ "\n");
        builder.append("\tCommunicationSlotNumber: " + cs.getCommunicationSlotNumber() + "\n");
        builder.append("\tReceivedStation: " + cs.getReceivedStation() + "\n");
        builder.append("\tCommunicationSlotOffset: " + cs.getCommunicationSlotOffset() + "\n");
        builder.append("}");
        return builder.toString();
    }

    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Message ID", String.valueOf(this.getMsgId()), Describer.describeMessageType(this.getMsgId()));
        ct.addRow("Repeater", String.valueOf(this.getRepeater()), Describer.describeRepeater(this.getRepeater()));
        ct.addRow("User ID (MMSI)", String.valueOf(this.getMMSI()), "");
        ct.addRow("Navigation Status", String.valueOf(this.getNavStatus()), Describer.describeNavigationStatus(this.getNavStatus()));
        ct.addRow("Rate of turn ROTAIS", String.valueOf(this.getROT()), "");
        ct.addRow("Speed Over Ground", String.valueOf(this.getSOG()), "");
        ct.addRow("Position Accuracy", String.valueOf(this.getPosAcc()), Describer.describePosAcc(this.getPosAcc()));
        ct.addRow("Longitude", String.valueOf(this.getLong()), "");
        ct.addRow("Latitude", String.valueOf(this.getLat()), "");
        ct.addRow("Course Over Ground", String.valueOf(this.getCog()), "");
        ct.addRow("True Heading", String.valueOf(this.getTrueHeading()), "");
        ct.addRow("Time Stamp", String.valueOf(this.getTimeStamp()), Describer.describeTimeStamp(this.getTimeStamp()));
        ct.addRow("Special Manoeuvre Indicator", String.valueOf(this.getSpecialManoeuvre()), Describer.describeSpecialManoeuvre(this.getSpecialManoeuvre()));
        ct.addRow("RAIM-flag", String.valueOf(this.getRaim()), Describer.describeRaim(this.getRaim()));
        ct.addRow("Communication State", String.valueOf(this.getCommunicationState()), "");
        ct.addRow("Sync State", String.valueOf(cs.getSyncState()), Describer.describeSyncState(cs.getSyncState()));
        ct.addRow("Slot Timeout", String.valueOf(cs.getSlotTimeOut()), Describer.describeSlotTimeOut(cs.getSlotTimeOut()));
        ct.addRow("Communication Sub Message", String.valueOf(cs.getSubMessageInt()),"");
        ct.addRow("Sub Message", cs.getSubMessage(),"");
        ct.addRow("Communication Slot Number",String.valueOf(cs.getCommunicationSlotNumber()),"");
        ct.addRow("Received Station",String.valueOf(cs.getReceivedStation()),"");
        ct.addRow("Communication Slot Offset", String.valueOf(cs.getCommunicationSlotOffset()), "");
        ct.print();
    }
}
