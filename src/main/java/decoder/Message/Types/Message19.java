package decoder.Message.Types;

import decoder.Binary.Binary;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
import decoder.Message.Encapsulated.Emessage;

public class Message19 extends Emessage {
  public Message19(){}
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
  };  private void assignFields(){
    this.assignSpare();
    this.assignPosAcc();
    this.assignSOG();
    this.assignLongitude();
    this.assignLatitude();
    this.assignCOG();
    this.assignTrueHeading();
    this.assignTimeStamp();
    this.assignSpare2();
    this.assignName();
    this.assignTypeOfShipAndCargo();
    this.assignDimension();
    this.assignElectronicPositionFixingDevice();
    this.assignRaim();
    this.assignDTE();
    this.assignAssignMode();
    this.assignSpare3();
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
  private void assignSpare3(){
    String spare3String = "";
    try{
      for(int i = 0; i < spare3Count; i++){
        spare3String += bitmap.toCharArray()[i + spare3Ptr];
      }
      setSpare3(Binary.convertToDec(spare3String));
    }catch (Exception e){
      setSpare3(0);
    }
  }
  private int spare;
  private Float speedOverGround;
  private int posAcc;
  private String longitude;
  private String latitude;
  private Float cog;
  private int trueHeading;
  private int timeStamp;
  private int spare2;
  private String name;
  private int typeOfShipAndCargoType;
  private String dimension;
  private int electronicPositionFixingDevice;
  private int raim;
  private int dte;
  private int assignedMode;
  private int spare3;
  private String bitmap = "";

  final int spareCount = 8, sparePtr = 38;
  final int sogCount = 10, sogPtr = 46;
  final int posAccCount = 1, posAccPtr =56;
  final int longCount = 28, longPtr = 57;
  final int latCount = 27, latPtr = 85;
  final int cogCount = 12, cogPtr = 112;
  final int trueHeadingCount = 9, trueHeadingPtr = 124;
  final int timeStampCount = 6, timeStampPtr = 133;
  final int spare2Count = 4, spare2Ptr = 139;
  final int nameCount = 120, namePtr = 143;
  final int shipTypeCount = 8, shipTypePtr = 263;
  final int dimCount = 30, dimPtr = 271;
  final int electronicCount = 4, electronicPtr = 301;
  final int raimCount = 1, raimPtr = 305;
  final int dteCount = 1, dtePtr = 306;
  final int assignModeCount = 1, assignModePtr = 307;
  final int spare3Count = 4, spare3Ptr = 308;

  /** Getters */
  public int getSpare(){
    return this.spare;
  }

  public Float getSOG(){
    return this.speedOverGround;
  }

  public int getPosAcc(){
    return this.posAcc;
  }

  public String getLon(){
    return this.longitude;
  }

  public String getLat(){
    return this.latitude;
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

  public int getSpare2(){
    return this.spare2;
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

  public int getRaim(){
    return this.raim;
  }

  public int getDte(){
    return this.dte;
  }

  public int getAssignMode(){
    return this.assignedMode;
  }

  public int getSpare3(){
    return this.spare3;
  }

  public String getBitMap(){
    return this.bitmap;
}

  /** Setters */
  public void setSpare(int i){
    this.spare = i;
  }

  public void setSOG(Float f){
    this.speedOverGround = f;
  }

  public void setPosAcc(int i){
    this.posAcc = i;
  }

  public void setLon(String s){
    this.longitude = s;
  }

  public void setLat(String s){
    this.latitude = s;
  }

  public void setCog(Float f){
    this.cog = f;
  }

  public void setTrueHeading(int i){
    this.trueHeading = i;
  }

  public void setTimeStamp(int _i){
    this.timeStamp = _i;
  }

  public void setSpare2(int i){
    this.spare2 = i;
  }

  public void setName(String s){
    this.name = s;
  }

  public void setTypeOfShipAndCargoType(int i){
    this.typeOfShipAndCargoType = i;
  }

  public void setDimension(String s){
    this.dimension = s;
  }

  public void setElectronicPositionFixingDevice(int i){
    this.electronicPositionFixingDevice = i;
  }

  public void setRaim(int i){
    this.raim = i;
  }

  public void setDte(int i){
    this.dte = i;
  }

  public void setAssignMode(int i){
    this.assignedMode = i;
  }

  public void setSpare3(int i){
    this.spare3 = i;
  }

  public void setBitMap(String s){
    this.bitmap = s;
  }

  public void setCommonField(Emessage e){
    this.setRepeater(e.getRepeater());
    this.setMsgId(e.getMsgId());
    this.setMMSI(e.getMMSI());
  }
  public String toJson() {
    StringBuilder builder = new StringBuilder();
    builder.append("Result: {\n");
    builder.append("\tMessageID: " + this.getMsgId() + "\n");
    builder.append("\tRepeater: " + this.getRepeater() + "\n");
    builder.append("\tMMSI: " + this.getMMSI() + "\n");
    builder.append("\tSpare: " + this.getSpare() + "\n");
    builder.append("\tSpeedOverGround: " + this.getSOG() + "\n");
    builder.append("\tPositionAccuracy: " + this.getPosAcc() + "\n");
    builder.append("\tLongitude: " + this.getLon() + "\n");
    builder.append("\tLatitude: " + this.getLat() + "\n");
    builder.append("\tCOG: " + this.getCog() + "\n");
    builder.append("\tTrueHeading: " + this.getTrueHeading() + "\n");
    builder.append("\tTimeStamp: " + this.getTimeStamp() + "\n");
    builder.append("\tSpare2: " + this.getSpare2() + "\n");
    builder.append("\tName: " + this.getName() + "\n");
    builder.append("\tTypeOfShipAndCargo: " + this.getTypeOfShipAndCargoType() + "\n");
    builder.append("\tOverallDimension: " + this.getDimension() + "\n");
    builder.append("\tTypeOfElectronicPositionFixingDevice: " + this.getElectronicPositionFixingDevice() + "\n");
    builder.append("\tRaimFlag: " + this.getRaim() + "\n");
    builder.append("\tDTE: " + this.getDte() + "\n");
    builder.append("\tAssignMode: " + this.getAssignMode() + "\n");
    builder.append("\tSpare3: " + this.getSpare3() + "\n");
    builder.append("}");
    return builder.toString();
  }
  private void toTable() {
    CommandTable ct = new CommandTable();
    ct.setShowVerticalLines(true);
    ct.setHeaders("Parameter", "Value", "Description");
    ct.addRow("Message ID", String.valueOf(this.getMsgId()), Describer.describeMessageType(this.getMsgId()));
    ct.addRow("Repeater", String.valueOf(this.getRepeater()),  Describer.describeRepeater(this.getRepeater()));
    ct.addRow("User ID (MMSI)", String.valueOf(this.getMMSI()), "");
    ct.addRow("Spare", String.valueOf(this.getSpare()), Describer.describeSpare(this.getSpare()));
    ct.addRow("Speed Over Ground", String.valueOf(this.getSOG()), "");
    ct.addRow("Position Accuracy", String.valueOf(this.getPosAcc()), Describer.describePosAcc(this.getPosAcc()));
    ct.addRow("Longitude", String.valueOf(this.getLon()), "");
    ct.addRow("Latitude", String.valueOf(this.getLat()), "");
    ct.addRow("Course Over Ground", String.valueOf(this.getCog()), "");
    ct.addRow("True Heading", String.valueOf(this.getTrueHeading()), "");
    ct.addRow("Time Stamp", String.valueOf(this.getTimeStamp()), Describer.describeTimeStamp(this.getTimeStamp()));
    ct.addRow("Spare", String.valueOf(this.getSpare2()), Describer.describeSpare(this.getSpare2()));
    ct.addRow("Name", String.valueOf(this.getName()), "");
    ct.addRow("Type Of Ship And Cargo Type", String.valueOf(this.getTypeOfShipAndCargoType()), Describer.describeShip(this.getTypeOfShipAndCargoType()));
    ct.addRow("Overall Dimension", String.valueOf(this.getDimension()), "");
    ct.addRow("Type Of Electronic Position Fixing Device", String.valueOf(this.getElectronicPositionFixingDevice()), Describer.describeElectronicPosition(this.getElectronicPositionFixingDevice()));
    ct.addRow("RAIM Flag", String.valueOf(this.getRaim()), Describer.describeRaim(this.getRaim()));
    ct.addRow("DTE", String.valueOf(this.getDte()), Describer.describeDTE(this.getDte()));
    ct.addRow("Assign Mode", String.valueOf(this.getAssignMode()), Describer.describeAssignMode(this.getAssignMode()));
    ct.addRow("Spare", String.valueOf(this.getSpare3()), Describer.describeSpare(this.getSpare3()));
    ct.print();
  }
}
