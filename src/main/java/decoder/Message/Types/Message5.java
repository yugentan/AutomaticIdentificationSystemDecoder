package decoder.Message.Types;

import decoder.Binary.Binary;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
import decoder.Message.Encapsulated.Emessage;

public class Message5 extends Emessage {
    public Message5(){}
    public void run(Emessage e){
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
    };    /** Getters*/
    public int getAisVersionIndicator(){
        return this.aisVersionIndicator;
    }
    public int getImoNumber(){
        return this.imoNumber;
    }
    public String getCallsign(){
        return this.callsign;
    }
    public String getName(){
        return this.name;
    }
    public int getTypeOfShipAndCargoType(){
        return this.typeOfShipAndCargoType;
    }
    public String getDimension(){
        return this.dimension;
    }
    public int getElectronicPositionFixingDevice(){
        return this.electronicPositionFixingDevice;
    }
    public String getETA(){
        return this.ETA;
    }

    public Float getStaticDraught() {
        return this.staticDraught;
    }
    public String getDestination(){
        return this.destination;
    }
    public int getDte(){
        return this.dte;
    }
    public int getSpare(){
        return this.spare;
    }
    public String getBitMap(){
        return this.bitmap;
    }
    /** Setters*/
    public void setAisVersionIndicator(int _i){
        this.aisVersionIndicator = _i;
    }
    public void setImoNumber(int _i){
        this.imoNumber = _i;
    }
    public void setCallsign(String _s){
        this.callsign = _s;
    }
    public void setName(String _s){
        this.name = _s;
    }
    public void setTypeOfShipAndCargoType(int _i){
        this.typeOfShipAndCargoType = _i;
    }
    public void setDimension(String _s){
        this.dimension = _s;
    }
    public void setElectronicPositionFixingDevice(int _i){
        this.electronicPositionFixingDevice = _i;
    }
    public void setETA(String _s){
        this.ETA = _s;
    }
    public void setStaticDraught(Float _f){
        this.staticDraught = _f;
    }
    public void setDestination(String _s){
        this.destination = _s;
    }
    public void setDte(int _i){
        this.dte = _i;
    }
    public void setSpare(int _i){
        this.spare = _i;
    }
    public void setBitMap(String _s){
        this.bitmap = _s;
    }
    public void setCommonField(Emessage e){
        this.setRepeater(e.getRepeater());
        this.setMsgId(e.getMsgId());
        this.setMMSI(e.getMMSI());
    }
    private void assignFields(){
        this.assignAisVersionIndicator();
        this.assignIMONumber();
        this.assignCallSign();
        this.assignName();
        this.assignTypeOfShipAndCargo();
        this.assignDimension();
        this.assignElectronicPositionFixingDevice();
        this.assignETA();
        this.assignDraught();
        this.assignDestination();
        this.assignDTE();
        this.assignSpare();
    }
    private void assignAisVersionIndicator(){
        String aviString = "";
        try{
            for(int i = 0; i < aisVerCount; i++){
                aviString += bitmap.toCharArray()[i + aisVerPtr];
            }
            setAisVersionIndicator(Binary.convertToDec(aviString));
        }catch (Exception e){
           setAisVersionIndicator(99);
        }
    }
    private void assignIMONumber(){
        String imoString = "";
        try{
            for(int i = 0; i < imoCount; i++){
                imoString += bitmap.toCharArray()[i + imoPtr];
            }
            setImoNumber(Binary.convertToDec(imoString));
        }catch (Exception e){
            setImoNumber(0);
        }
    }
    private void assignCallSign(){
        String callSignString = "";
        try {
            for(int i = 0; i < callSignCount; i++){
                callSignString += bitmap.toCharArray()[i + callSignPtr];
            }
            setCallsign(Describer.describeCallSign(callSignString));
        }catch (Exception e){
            setCallsign("");
        }
    }
    private void assignName(){
        String nameString = "";
        try {
            for (int i = 0; i < nameCount; i++) {
                nameString += bitmap.toCharArray()[i + namePtr];
            }
            setName(Describer.describeName(nameString));
        }catch (Exception e){
            setName("");
        }
    }
    private void assignTypeOfShipAndCargo(){
        String typeString = "";
        try{
            for(int i = 0; i < shipTypeCount; i++){
                typeString += bitmap.toCharArray()[i + shipTypePtr];
            }
            setTypeOfShipAndCargoType(Binary.convertToDec(typeString));
        }catch (Exception e){
            setTypeOfShipAndCargoType(0);
        }
    }
    private void assignDimension(){
        String dimensionString = "";
        try {
            for(int i = 0; i < dimCount; i++){
                dimensionString += bitmap.toCharArray()[i + dimPtr];
            }
            setDimension(Binary.evaluateDimension(dimensionString));
        }catch (Exception e){
            setDimension("");
        }
    }
    private void assignElectronicPositionFixingDevice(){
        String epfdString = "";
        try {
            for(int i = 0; i < electronicCount; i++){
                epfdString += bitmap.toCharArray()[i + electronicPtr];
            }
            setElectronicPositionFixingDevice(Binary.convertToDec(epfdString));
        }catch (Exception e){
            setElectronicPositionFixingDevice(0);
        }
    }
    private void assignETA(){
        String etaString = "";
        try{
            for(int i = 0; i < etaCount; i++){
                etaString += bitmap.toCharArray()[i + etaPtr];
            }
            setETA(Binary.binaryToUTCETA(etaString));
        }catch (Exception e){
            setETA("");
        }
    }
    private void assignDraught(){
        String draughtString = "";
        try{
            for(int i = 0; i < draughtCount; i++){
                draughtString += bitmap.toCharArray()[i + draughtPtr];
            }
            setStaticDraught(Binary.getDraught(Binary.convertToDec(draughtString)));
        }catch (Exception e){
            setStaticDraught(0.0f);
        }
    }
    private void assignDestination(){
        String desString = "";
        try{
            for(int i = 0; i < destinationCount; i++){
                desString += bitmap.toCharArray()[i + destinationPtr];
            }
            setDestination(Describer.describeDestination(desString));
        }catch (Exception e){
            setDestination("");
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
    private int aisVersionIndicator;
    private int imoNumber;
    private String callsign;
    private String name;
    private int typeOfShipAndCargoType;
    private String dimension;
    private int electronicPositionFixingDevice;
    private String ETA;
    private Float staticDraught;
    private String destination;
    private int dte;
    private int spare;
    private String bitmap = "";
    final int aisVerCount = 2, aisVerPtr = 38 ;
    final int imoCount = 30, imoPtr = 40;
    final int callSignCount = 42, callSignPtr = 70;
    final int nameCount = 120, namePtr = 112;
    final int shipTypeCount = 8, shipTypePtr = 232;
    final int dimCount = 30, dimPtr = 240;
    final int electronicCount = 4, electronicPtr = 270;
    final int etaCount = 20, etaPtr = 274;
    final int draughtCount = 8, draughtPtr = 294;
    final int destinationCount = 120, destinationPtr = 302;
    final int dteCount = 1, dtePtr = 422;
    final int spareCount = 1, sparePtr = 423;

    public String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tMessageID: " + this.getMsgId() + "\n");
        builder.append("\tRepeater: " + this.getRepeater() + "\n");
        builder.append("\tMMSI: " + this.getMMSI() + "\n");
        builder.append("\tAISVersionIndicator: " + this.getAisVersionIndicator() + "\n");
        builder.append("\tIMONumber: " + this.getImoNumber() + "\n");
        builder.append("\tCallSign: " + this.getCallsign() + "\n" );
        builder.append("\tName: " + this.getName() + "\n");
        builder.append("\tTypeOfShipAndCargo: " + this.getTypeOfShipAndCargoType() + "\n");
        builder.append("\tOverallDimension: " + this.getDimension() + "\n");
        builder.append("\tTypeOfElectronicPositionFixingDevice: " + this.getElectronicPositionFixingDevice() + "\n");
        builder.append("\tETA: " + this.getETA() + "\n");
        builder.append("\tMaximumPresentStaticDraught: " + this.getStaticDraught() + "\n");
        builder.append("\tDestination: " + this.getDestination() + "\n");
        builder.append("\tDTE: " + this.getDte() + "\n");
        builder.append("\tSpare: " + this.getSpare() + "\n");
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
        ct.addRow("AIS Version Indicator",String.valueOf(this.getAisVersionIndicator()), Describer.describeAISIndicator(this.getAisVersionIndicator()));
        ct.addRow("IMO Number", String.valueOf(this.getImoNumber()), "");
        ct.addRow("Call Sign", String.valueOf(this.getCallsign()), "");
        ct.addRow("Name", String.valueOf(this.getName()), "");
        ct.addRow("Type Of Ship And Cargo Type", String.valueOf(this.getTypeOfShipAndCargoType()), Describer.describeShip(this.getTypeOfShipAndCargoType()));
        ct.addRow("Overall Dimension", String.valueOf(this.getDimension()), "");
        ct.addRow("Type Of Electronic Position Fixing Device", String.valueOf(this.getElectronicPositionFixingDevice()), Describer.describeElectronicPosition(this.getElectronicPositionFixingDevice()));
        ct.addRow("ETA", String.valueOf(this.getETA()), Describer.describeETA(this.getETA()));
        ct.addRow("Maximum Present Static Draught", String.valueOf(this.getStaticDraught()), "");
        ct.addRow("Destination", String.valueOf(this.getDestination()), "");
        ct.addRow("DTE", String.valueOf(this.getDte()), Describer.describeDTE(this.getDte()));
        ct.addRow("Spare", String.valueOf(this.getSpare()), "");
        ct.print();
    }
}
