package decoder.Message.Parametric;

import decoder.Binary.Binary;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
public class ACA {
	public ACA(){};
	public void table(){
		try {
			this.toTable();
		}catch (Exception e){
			System.out.println("NULL EXPECTED IN TABLE: ACA");
		}
	}
	public void json(){
		System.out.println(this.toJson());
	}
	public void decode(String _s){
		String[] s = _s.split(",");
		try{
			setSequenceNumber(Integer.parseInt(s[1]));
			setRegionNorthEastCornerLatitude(Float.parseFloat(s[2]));
			setRegionNorthEastCornerLatitudeUnit(s[3].charAt(0));
			setRegionNorthEastCornerLongitude(Float.parseFloat(s[4]));
			setRegionNorthEastCornerLongitudeUnit(s[5].charAt(0));
			setRegionSouthWestCornerLatitude(Float.parseFloat(s[6]));
			setRegionSouthWestCornerLatitudeUnit(s[7].charAt(0));
			setRegionSouthWestCornerLongitude(Float.parseFloat(s[8]));
			setRegionSouthWestCornerLongitudeUnit(s[9].charAt(0));
			setTransitionZoneSize(Integer.parseInt(s[10]));
			setTransitionZoneUnit(s[11].charAt(0));
			setChannelA(s[12].charAt(0));
			setChannelABandwidth(Integer.parseInt(s[13]));
			setChannelB(s[14].charAt(0));
			setChannelBBandwidth(Integer.parseInt(s[15]));
			setTxRxMode(Integer.parseInt(s[16]));
			setPowerLevelControl(Integer.parseInt(s[17]));
			setInformationSource(s[18].charAt(0));
			setInUseFlag(Integer.parseInt(s[19]));
		}catch (Exception e){
			System.out.println("Sentence: " +  _s + " contains invalid fields");
		}
	}
	private int sequenceNumber;
	public void setSequenceNumber(int sequenceNumber){
		if(sequenceNumber>=0 && sequenceNumber<=9){
			this.sequenceNumber=sequenceNumber;
		}
	}
	public int getSequenceNumber(){
		return this.sequenceNumber;
	}
	private Float regionNorthEastCornerLatitude;
	public void setRegionNorthEastCornerLatitude(Float regionNorthEastCornerLatitude){
		if(regionNorthEastCornerLatitude>=0.0 && regionNorthEastCornerLatitude<=360.0){
			this.regionNorthEastCornerLatitude=regionNorthEastCornerLatitude;
		}
	}
	public Float getRegionNorthEastCornerLatitude(){
		return this.regionNorthEastCornerLatitude;
	}
	private char regionNorthEastCornerLatitudeUnit;
	public void setRegionNorthEastCornerLatitudeUnit(char regionNorthEastCornerLatitudeUnit){
		if(regionNorthEastCornerLatitudeUnit=='N' || regionNorthEastCornerLatitudeUnit=='S'){
			this.regionNorthEastCornerLatitudeUnit=regionNorthEastCornerLatitudeUnit;
		}
	}
	public char getRegionNorthEastCornerLatitudeUnit(){
		return this.regionNorthEastCornerLatitudeUnit;
	}
	private Float regionNorthEastCornerLongitude;
	public void setRegionNorthEastCornerLongitude(Float regionNorthEastCornerLongitude){
		if(regionNorthEastCornerLongitude>=0.0 && regionNorthEastCornerLongitude<=360.0){
			this.regionNorthEastCornerLongitude=regionNorthEastCornerLongitude;
		}
	}
	public Float getRegionNorthEastCornerLongitude(){
		return this.regionNorthEastCornerLongitude;
	}
	private char regionNorthEastCornerLongitudeUnit;
	public void setRegionNorthEastCornerLongitudeUnit(char regionNorthEastCornerLongitudeUnit){
		if(regionNorthEastCornerLongitudeUnit=='E' || regionNorthEastCornerLongitudeUnit=='W'){
			this.regionNorthEastCornerLongitudeUnit=regionNorthEastCornerLongitudeUnit;
		}
	}
	public char getRegionNorthEastCornerLongitudeUnit(){
		return this.regionNorthEastCornerLongitudeUnit;
	}
	private Float regionSouthWestCornerLatitude;
	public void setRegionSouthWestCornerLatitude(Float regionSouthWestCornerLatitude){
		if(regionSouthWestCornerLatitude>=0.0 && regionSouthWestCornerLatitude<=360.0){
			this.regionSouthWestCornerLatitude=regionSouthWestCornerLatitude;
		}
	}
	public Float getRegionSouthWestCornerLatitude(){
		return this.regionSouthWestCornerLatitude;
	}
	private char regionSouthWestCornerLatitudeUnit;
	public void setRegionSouthWestCornerLatitudeUnit(char regionSouthWestCornerLatitudeUnit){
		if(regionSouthWestCornerLatitudeUnit=='N' || regionSouthWestCornerLatitudeUnit=='S'){
			this.regionSouthWestCornerLatitudeUnit=regionSouthWestCornerLatitudeUnit;
		}
	}
	public char getRegionSouthWestCornerLatitudeUnit(){
		return this.regionSouthWestCornerLatitudeUnit;
	}
	private Float regionSouthWestCornerLongitude;
	public void setRegionSouthWestCornerLongitude(Float regionSouthWestCornerLongitude){
		if(regionSouthWestCornerLongitude>=0.0 && regionSouthWestCornerLongitude<=360.0){
			this.regionSouthWestCornerLongitude=regionSouthWestCornerLongitude;
		}
	}
	public Float getRegionSouthWestCornerLongitude(){
		return this.regionSouthWestCornerLongitude;
	}
	private char regionSouthWestCornerLongitudeUnit;
	public void setRegionSouthWestCornerLongitudeUnit(char regionSouthWestCornerLongitudeUnit){
		if(regionSouthWestCornerLongitudeUnit=='E' || regionSouthWestCornerLongitudeUnit=='W'){
			this.regionSouthWestCornerLongitudeUnit=regionSouthWestCornerLongitudeUnit;
		}
	}
	public char getRegionSouthWestCornerLongitudeUnit(){
		return this.regionSouthWestCornerLongitudeUnit;
	}
	private int transitionZoneSize;
	public void setTransitionZoneSize(int transitionZoneSize){
		if(transitionZoneSize>=1 && transitionZoneSize<=8){
			this.transitionZoneSize=transitionZoneSize;
		}
	}
	public int getTransitionZoneSize(){
		return this.transitionZoneSize;
	}
	private char transitionZoneUnit;
	public void setTransitionZoneUnit(char transitionZoneUnit){
		if(transitionZoneUnit=='N'){
			this.transitionZoneUnit=transitionZoneUnit;
		}
	}
	public char getTransitionZoneUnit(){
		return this.transitionZoneUnit;
	}
	private char channelA;
	public void setChannelA(char channelA){
		if(channelA=='A'){
			this.channelA=channelA;
		}
	}
	public char getChannelA(){
		return this.channelA;
	}
	private int channelABandwidth;
	public void setChannelABandwidth(int channelABandwidth){
		if(channelABandwidth>=0 && channelABandwidth<=1){
			this.channelABandwidth=channelABandwidth;
		}
	}
	public int getChannelABandwidth(){
		return this.channelABandwidth;
	}
	private char channelB;
	public void setChannelB(char channelB){
		if(channelB=='B'){
			this.channelB=channelB;
		}
	}
	public char getChannelB(){
		return this.channelB;
	}
	private int channelBBandwidth;
	public void setChannelBBandwidth(int channelBBandwidth){
		if(channelBBandwidth>=0 && channelBBandwidth<=1){
			this.channelBBandwidth=channelBBandwidth;
		}
	}
	public int getChannelBBandwidth(){
		return this.channelBBandwidth;
	}
	private int TxRxMode;
	public void setTxRxMode(int TxRxMode){
		if(TxRxMode>=0 && TxRxMode<=5){
			this.TxRxMode=TxRxMode;
		}
	}
	public int getTxRxMode(){
		return this.TxRxMode;
	}
	private int powerLevelControl;
	public void setPowerLevelControl(int powerLevelControl){
		if(powerLevelControl>=0 && powerLevelControl<=1){
			this.powerLevelControl=powerLevelControl;
		}
	}
	public int getPowerLevelControl(){
		return this.powerLevelControl;
	}
	private char informationSource;
	public void setInformationSource(char informationSource){
		if(informationSource=='A' || informationSource=='B' || informationSource=='C' || informationSource=='D' || informationSource=='M'){
			this.informationSource=informationSource;
		}
	}
	public char getInformationSource(){
		return this.informationSource;
	}
	private int inUseFlag;
	public void setInUseFlag(int inUseFlag){
		if(inUseFlag>=0 && inUseFlag<=1){
			this.inUseFlag=inUseFlag;
		}
	}
	public int getInUseFlag(){
		return this.inUseFlag;
	}
	private String timeOfInUseChange;
	public void setTimeOfInUseChange(String timeOfInUseChange){
		if(Binary.isValidTime(timeOfInUseChange)){
			this.timeOfInUseChange=timeOfInUseChange;
		}
	}
	public String getTimeOfInUseChange(){
		return this.timeOfInUseChange;
	}
	public String getTalker(){
		return this.talker;
	}
	public String getFormat(){
		return this.format;
	}
	public void setTalker(String talker){
		this.talker = talker;
	}
	public void setFormat(String format){
		this.format = format;
	}
	public String talker;
	public String format;
	private String toJson(){
		StringBuilder builder = new StringBuilder();
		builder.append("Result: {\n");
		builder.append("\tTalker: " + this.getTalker() + "\n");
		builder.append("\tFormat: " + this.getFormat() + "\n");
		builder.append("\tsequenceNumber: " + String.valueOf(this.getSequenceNumber()) + "\n");
		builder.append("\tregionNorthEastCornerLatitude: " + this.getRegionNorthEastCornerLatitude() + "\n");
		builder.append("\tregionNorthEastCornerLatitudeUnit: " + this.getRegionNorthEastCornerLatitudeUnit() + "\n");
		builder.append("\tregionNorthEastCornerLongitude: " + this.getRegionNorthEastCornerLongitude() + "\n");
		builder.append("\tregionNorthEastCornerLongitudeUnit: " + this.getRegionNorthEastCornerLongitudeUnit() + "\n");
		builder.append("\tregionSouthWestCornerLatitude: " + this.getRegionSouthWestCornerLatitude() + "\n");
		builder.append("\tregionSouthWestCornerLatitudeUnit: " + this.getRegionSouthWestCornerLatitudeUnit() + "\n");
		builder.append("\tregionSouthWestCornerLongitude: " + this.getRegionSouthWestCornerLongitude() + "\n");
		builder.append("\tregionSouthWestCornerLongitudeUnit: " + this.getRegionSouthWestCornerLongitudeUnit() + "\n");
		builder.append("\ttransitionZoneSize: " + String.valueOf(this.getTransitionZoneSize()) + "\n");
		builder.append("\ttransitionZoneUnit: " + this.getTransitionZoneUnit() + "\n");
		builder.append("\tchannelA: " + this.getChannelA() + "\n");
		builder.append("\tchannelABandwidth: " + String.valueOf(this.getChannelABandwidth()) + "\n");
		builder.append("\tchannelB: " + this.getChannelB() + "\n");
		builder.append("\tchannelBBandwidth: " + String.valueOf(this.getChannelBBandwidth()) + "\n");
		builder.append("\tTxRxMode: " + String.valueOf(this.getTxRxMode()) + "\n");
		builder.append("\tpowerLevelControl: " + String.valueOf(this.getPowerLevelControl()) + "\n");
		builder.append("\tinformationSource: " + this.getInformationSource() + "\n");
		builder.append("\tinUseFlag: " + String.valueOf(this.getInUseFlag()) + "\n");
		builder.append("\ttimeOfInUseChange: " + this.getTimeOfInUseChange() + "\n");
		builder.append("}");
		return builder.toString();
	}
	private void toTable(){
		CommandTable ct = new CommandTable();
		ct.setShowVerticalLines(true);
		ct.setHeaders("Parameter","Value","Description");
		ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
		ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
		ct.addRow("sequenceNumber", String.valueOf(this.getSequenceNumber()), "");
		ct.addRow("regionNorthEastCornerLatitude", String.valueOf(this.getRegionNorthEastCornerLatitude()), "");
		ct.addRow("regionNorthEastCornerLatitudeUnit", String.valueOf(this.getRegionNorthEastCornerLatitudeUnit()), "");
		ct.addRow("regionNorthEastCornerLongitude", String.valueOf(this.getRegionNorthEastCornerLongitude()), "");
		ct.addRow("regionNorthEastCornerLongitudeUnit", String.valueOf(this.getRegionNorthEastCornerLongitudeUnit()), "");
		ct.addRow("regionSouthWestCornerLatitude", String.valueOf(this.getRegionSouthWestCornerLatitude()), "");
		ct.addRow("regionSouthWestCornerLatitudeUnit", String.valueOf(this.getRegionSouthWestCornerLatitudeUnit()), "");
		ct.addRow("regionSouthWestCornerLongitude", String.valueOf(this.getRegionSouthWestCornerLongitude()), "");
		ct.addRow("regionSouthWestCornerLongitudeUnit", String.valueOf(this.getRegionSouthWestCornerLongitudeUnit()), "");
		ct.addRow("transitionZoneSize", String.valueOf(this.getTransitionZoneSize()), "");
		ct.addRow("transitionZoneUnit", String.valueOf(this.getTransitionZoneUnit()), "");
		ct.addRow("channelA", String.valueOf(this.getChannelA()), "");
		ct.addRow("channelABandwidth", String.valueOf(this.getChannelABandwidth()), "");
		ct.addRow("channelB", String.valueOf(this.getChannelB()), "");
		ct.addRow("channelBBandwidth", String.valueOf(this.getChannelBBandwidth()), "");
		ct.addRow("TxRxMode", String.valueOf(this.getTxRxMode()), "");
		ct.addRow("powerLevelControl", String.valueOf(this.getPowerLevelControl()), "");
		ct.addRow("informationSource", String.valueOf(this.getInformationSource()), "");
		ct.addRow("inUseFlag", String.valueOf(this.getInUseFlag()), "");
		ct.addRow("timeOfInUseChange", String.valueOf(this.getTimeOfInUseChange()), "");
		ct.print();
	}
}