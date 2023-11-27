package decoder.Message.Parametric;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
public class BOD {
	public BOD(){};
	public void table(){
		try {
			this.toTable();
		}catch (Exception e){
			System.out.println("NULL EXPECTED IN TABLE: BOD");
		}
	}
	public void json(){
		System.out.println(this.toJson());
	}
	public void decode(String _s){
		String[] s = _s.split(",");
		try{
			setTrueBearing(Float.parseFloat(s[1]));
			setTrueBearingUnit(s[2].charAt(0));
			setMagneticBearing(Float.parseFloat(s[3]));
			setMagneticBearingUnit(s[4].charAt(0));
			setDestinationWaypointID(s[5]);
			setOriginWaypoiID(s[6].split("\\*")[0]);
		}catch (Exception e){
			System.out.println("Sentence: " +  _s + " contains invalid fields");
		}
	}
	private Float trueBearing;
	public void setTrueBearing(Float trueBearing){
		if(trueBearing>=1 && trueBearing<=180){
			this.trueBearing=trueBearing;
		}
	}
	public Float getTrueBearing(){
		return this.trueBearing;
	}
	private char trueBearingUnit;
	public void setTrueBearingUnit(char trueBearingUnit){
		if(trueBearingUnit=='T'){
			this.trueBearingUnit=trueBearingUnit;
		}
	}
	public char getTrueBearingUnit(){
		return this.trueBearingUnit;
	}
	private Float magneticBearing;
	public void setMagneticBearing(Float magneticBearing){
		if(magneticBearing>=1 && magneticBearing<=180){
			this.magneticBearing=magneticBearing;
		}
	}
	public Float getMagneticBearing(){
		return this.magneticBearing;
	}
	private char magneticBearingUnit;
	public void setMagneticBearingUnit(char magneticBearingUnit){
		if(magneticBearingUnit=='M'){
			this.magneticBearingUnit=magneticBearingUnit;
		}
	}
	public char getMagneticBearingUnit(){
		return this.magneticBearingUnit;
	}
	private String destinationWaypointID;
	public void setDestinationWaypointID(String destinationWaypointID){
		this.destinationWaypointID=destinationWaypointID;
	}
	public String getDestinationWaypointID(){
		return this.destinationWaypointID;
	}
	private String originWaypoiID;
	public void setOriginWaypoiID(String originWaypoiID){
		this.originWaypoiID=originWaypoiID;
	}
	public String getOriginWaypoiID(){
		return this.originWaypoiID;
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
		builder.append("\ttrueBearing: " + this.getTrueBearing() + "\n");
		builder.append("\ttrueBearingUnit: " + this.getTrueBearingUnit() + "\n");
		builder.append("\tmagneticBearing: " + this.getMagneticBearing() + "\n");
		builder.append("\tmagneticBearingUnit: " + this.getMagneticBearingUnit() + "\n");
		builder.append("\tdestinationWaypointID: " + this.getDestinationWaypointID() + "\n");
		builder.append("\toriginWaypoiID: " + this.getOriginWaypoiID() + "\n");
		builder.append("}");
		return builder.toString();
	}
	private void toTable(){
		CommandTable ct = new CommandTable();
		ct.setShowVerticalLines(true);
		ct.setHeaders("Parameter","Value","Description");
		ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
		ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
		ct.addRow("trueBearing", String.valueOf(this.getTrueBearing()), "");
		ct.addRow("trueBearingUnit", String.valueOf(this.getTrueBearingUnit()), "");
		ct.addRow("magneticBearing", String.valueOf(this.getMagneticBearing()), "");
		ct.addRow("magneticBearingUnit", String.valueOf(this.getMagneticBearingUnit()), "");
		ct.addRow("destinationWaypointID", this.getDestinationWaypointID(), "");
		ct.addRow("originWaypoiID", this.getOriginWaypoiID(), "");
		ct.print();
	}
}