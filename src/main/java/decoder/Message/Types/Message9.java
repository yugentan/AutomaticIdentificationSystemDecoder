
package decoder.Message.Types;

import decoder.Binary.Binary;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
import decoder.Communication.CommunicationState;
import decoder.Message.Encapsulated.Emessage;

public class Message9 extends Emessage{
    public Message9(){};
    public void run (Emessage e){
        this.setBitMap(e.getBitmap());
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
    };    public void setBitMap(String _bitString){
        this.bitmap = _bitString;
    }
    public void setCommonField(Emessage e){
        this.setRepeater(e.getRepeater());
        this.setMsgId(e.getMsgId());
        this.setMMSI(e.getMMSI());
    }
    private void assignFields() {
        this.assignAltitude();
        this.assignSog();
        this.assignPosAcc();
        this.assignLongitude();
        this.assignLatitude();
        this.assignCOG();
        this.assignTimeStamp();
        this.assignAltSensor();
        this.assignSpare();
        this.assignDTE();
        this.assignSpare2();
        this.assignRaim();
        this.assignAssignMode();
        this.assignCommsSelector();
        this.assignCommsState();
    }

    private void assignAltitude(){
        String altitudeString = "";
        try{
            for(int i = 0; i < altitudeCount; i ++){
                altitudeString += bitmap.toCharArray()[i + altitudePtr];
            }
            setAltitude((float)Binary.convertToDec(altitudeString));
        }catch (Exception e){
            setAltitude(4095.0f);
        }
    }
    private void assignSog(){
        String sogString = "";
        try{
            for(int i = 0; i < sogCount; i++){
                sogString += bitmap.toCharArray()[i + sogPtr];
            }
            setSOG(Binary.getSOG(Binary.convertToDec(sogString)));
        }catch (Exception e){
            setSOG(Binary.getSOG(1023));
        }
    }
    private void assignPosAcc(){
        String posAccString = "";
        try {
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
    private void assignAltSensor(){
        String sensorString = "";
        try{
            for (int i = 0; i < altSensorCount; i++){
                sensorString += bitmap.toCharArray()[i + altSensorPtr];
            }
            setAltSensor(Binary.convertToDec(sensorString));
        }catch (Exception e){
            setAltSensor(0);
        }
    }
    private void assignSpare(){
        String spareString = "";
        try{
            for (int i = 0; i < spareCount; i++){
                spareString += bitmap.toCharArray()[i + sparePtr];
            }
            setSpare(Binary.convertToDec(spareString));
        }catch (Exception e){
            setSpare(0);
        }
    }
    private void assignDTE(){
        String dteString = "";
        try {
            for(int i = 0; i < dteCount; i++){
                dteString += bitmap.toCharArray()[i + dtePtr];
            }
            setDte(Binary.convertToDec(dteString));
        }catch (Exception e){
            setDte(1);
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
    private void assignAssignMode(){
        String assignModeString = "";
        try {
            for(int i = 0; i < assignModeCount; i++){
                assignModeString += bitmap.toCharArray()[i + assignModePtr];
            }
            setAssignMode(Binary.convertToDec(assignModeString));
        }catch (Exception e){
            setAssignMode(0);
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
            setCommsSelector(Binary.convertToDec(commsSelectorString));
            if(Binary.convertToDec(commsSelectorString) == 0){
                cs.setCsState(true);
            }
        }catch (Exception e){
            setCommsSelector(0); //sotdma
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
    /** Getters*/
    public Float getAltitude(){
        return this.altitude;
    }
    public Float getSOG(){
        return this.speedOverGround;
    }
    public int getPosAcc(){
        return this.posAcc;
    }
    public String getLong(){
        return this.longitude;
    }
    public String getLat(){
        return this.latitude;
    }
    public Float getCog(){
        return this.cog;
    }
    public int getTimeStamp(){
        return this.timeStamp;
    }
    public int getAltSensor(){
        return this.altSensor;
    }
    public int getSpare(){
        return this.spare;
    }
    public int getSpare2(){
        return this.spare2;
    }
    public int getDte(){
        return this.dte;
    }
    public int getAssignMode(){
        return this.assignMode;
    }
    public int getRaim(){
        return this.raim;
    }
    public int getCommsSelector(){
        return this.commsSelector;
    }
    public int getCommunicationState(){
        return this.communicationState;
    }
    /** Setters*/
    public void setAltitude(Float _f){
        this.altitude = _f;
    }
    public void setSOG(Float _f){
        this.speedOverGround = _f;
    }
    public void setPosAcc(int _i){
        this.posAcc = _i;
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
    public void setTimeStamp(int _i){
        this.timeStamp = _i;
    }
    public void setAltSensor(int _i){
        this.altSensor = _i;
    }
    public void setSpare(int _i){
        this.spare = _i;
    }
    public void setSpare2(int _i){
        this.spare2 = _i;
    }
    public void setDte(int _i){
        this.dte = _i;
    }
    public void setAssignMode(int _i){
        this.assignMode = _i;
    }
    public void setRaim(int _i){
        this.raim = _i;
    }
    public void setCommsSelector(int _i) {
        this.commsSelector = _i;
    }
    public void setCommunicationState(int i){
        this.communicationState = i;
    }
    private String bitmap;
    private Float altitude;
    private Float speedOverGround;
    private int posAcc;
    private String longitude;
    private String latitude;
    private Float cog;
    private int timeStamp;
    private int altSensor;
    private int spare;
    private int spare2;
    private int dte;
    private int assignMode;
    private int raim;
    private int commsSelector;
    private int communicationState;
    private CommunicationState cs = new CommunicationState();
    private int altitudePtr = 38, altitudeCount = 12;
    private int sogPtr = 50, sogCount = 10;
    private int posAccPtr = 60, posAccCount = 1;
    private int longPtr = 61, longCount = 28;
    private int latPtr = 89, latCount = 27;
    private int cogPtr = 116, cogCount = 12;
    private int timeStampPtr = 128, timeStampCount = 6;
    private int altSensorPtr = 134, altSensorCount = 1;
    private int sparePtr = 135, spareCount = 7;
    private int dtePtr = 142, dteCount = 1;
    private int spare2Ptr = 143, spare2Count = 3;
    private int assignModePtr = 146, assignModeCount = 1;
    private int raimPtr = 147, raimCount = 1;
    private int commsSelectorPtr = 148, commsSelectorCount = 1;
    private int commsStatePtr = 149, commsStateCount = 19;
    public String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tMessageID: " + this.getMsgId() + "\n");
        builder.append("\tRepeater: " + this.getRepeater() + "\n");
        builder.append("\tMMSI: " + this.getMMSI() + "\n");
        builder.append("\tAltitude: " + this.getAltitude() + "\n");
        builder.append("\tSpeedOverGround: " + this.getSOG() + "\n");
        builder.append("\tPositionAccuracy: " + this.getPosAcc() + "\n");
        builder.append("\tLongitude: " + this.getLong() + "\n");
        builder.append("\tLatitude: " + this.getLat() + "\n");
        builder.append("\tCOG: " + this.getCog() + "\n");
        builder.append("\tTimeStamp: " + this.getTimeStamp() + "\n");
        builder.append("\tAltitudeSensor: " + this.getAltSensor() + "\n");
        builder.append("\tSpare: " + this.getSpare() + "\n");
        builder.append("\tDTE: " + this.getDte() + "\n");
        builder.append("\tSpare2: " + this.getSpare2() + "\n");
        builder.append("\tAssignMode: " + this.getAssignMode() + "\n");
        builder.append("\tRaimFlag: " + this.getRaim() + "\n");
        builder.append("\tCommunicationSelector: " + this.getCommsSelector() + "\n");
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
    public void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Message ID", String.valueOf(this.getMsgId()), Describer.describeMessageType(this.getMsgId()));
        ct.addRow("Repeater", String.valueOf(this.getRepeater()),  Describer.describeRepeater(this.getRepeater()));
        ct.addRow("User ID (MMSI)", String.valueOf(this.getMMSI()), "");
        ct.addRow("Altitude", String.valueOf(this.getAltitude()),"");
        ct.addRow("Speed Over Ground", String.valueOf(this.getSOG()), "");
        ct.addRow("Position Accuracy", String.valueOf(this.getPosAcc()), Describer.describePosAcc(this.getPosAcc()));
        ct.addRow("Longitude", String.valueOf(this.getLong()), "");
        ct.addRow("Latitude", String.valueOf(this.getLat()), "");
        ct.addRow("Course Over Ground", String.valueOf(this.getCog()), "");
        ct.addRow("Time Stamp", String.valueOf(this.getTimeStamp()), Describer.describeTimeStamp(this.getTimeStamp()));
        ct.addRow("Altitude Sensor", String.valueOf(this.getAltSensor()), Describer.describeAltitudeSensor(this.getAltSensor()));
        ct.addRow("Spare", String.valueOf(this.getSpare()), Describer.describeSpare(this.getSpare()));
        ct.addRow("DTE", String.valueOf(this.getDte()), Describer.describeDTE(this.getDte()));
        ct.addRow("Spare", String.valueOf(this.getSpare2()), Describer.describeSpare(this.getSpare2()));
        ct.addRow("Assign Mode", String.valueOf(this.getAssignMode()), Describer.describeAssignMode(this.getAssignMode()));
        ct.addRow("RAIM flag", String.valueOf(this.getRaim()), Describer.describeRaim(this.getRaim()));
        ct.addRow("Communication Selector", String.valueOf(this.getCommsSelector()), Describer.describeCommsSelector(this.getCommsSelector()));
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
