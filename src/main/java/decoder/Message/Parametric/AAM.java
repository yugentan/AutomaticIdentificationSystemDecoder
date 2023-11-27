package decoder.Message.Parametric;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
public class AAM {
	public AAM(){};
	public void table(){
		try {
			this.toTable();
		}catch (Exception e){
			System.out.println("NULL EXPECTED IN TABLE: AAM");
		}
	}
	public void json(){
		System.out.println(this.toJson());
	}
	public void decode(String _s){
		String[] s = _s.split(",");
		try{
			setArrivalCircleStatus(s[1].charAt(0));
			setPerpendicularWaypointStatus(s[2].charAt(0));
			setArrivalCircleRadius(Float.parseFloat(s[3]));
			setUnitOfRadius(s[4].charAt(0));
			setWaypointID(s[5].split("\\*")[0]);
		}catch (Exception e){
			System.out.println("Sentence: " +  _s + " contains invalid fields");
		}
	}
	private char arrivalCircleStatus;
	public void setArrivalCircleStatus(char arrivalCircleStatus){
		if(arrivalCircleStatus=='A' || arrivalCircleStatus=='V'){
			this.arrivalCircleStatus=arrivalCircleStatus;
		}
	}
	public char getArrivalCircleStatus(){
		return this.arrivalCircleStatus;
	}
	private char perpendicularWaypointStatus;
	public void setPerpendicularWaypointStatus(char perpendicularWaypointStatus){
		if(perpendicularWaypointStatus=='A' || perpendicularWaypointStatus=='V'){
			this.perpendicularWaypointStatus=perpendicularWaypointStatus;
		}
	}
	public char getPerpendicularWaypointStatus(){
		return this.perpendicularWaypointStatus;
	}
	private Float arrivalCircleRadius;
	public void setArrivalCircleRadius(Float arrivalCircleRadius){
		if(arrivalCircleRadius>=0.05 && arrivalCircleRadius<=926.77){
			this.arrivalCircleRadius=arrivalCircleRadius;
		}
	}
	public Float getArrivalCircleRadius(){
		return this.arrivalCircleRadius;
	}
	private char unitOfRadius;
	public void setUnitOfRadius(char unitOfRadius){
		if(unitOfRadius=='N'){
			this.unitOfRadius=unitOfRadius;
		}
	}
	public char getUnitOfRadius(){
		return this.unitOfRadius;
	}
	private String waypointID;
	public void setWaypointID(String waypointID){
		this.waypointID=waypointID;
	}
	public String getWaypointID(){
		return this.waypointID;
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
		builder.append("\tarrivalCircleStatus: " + this.getArrivalCircleStatus() + "\n");
		builder.append("\tperpendicularWaypointStatus: " + this.getPerpendicularWaypointStatus() + "\n");
		builder.append("\tarrivalCircleRadius: " + this.getArrivalCircleRadius() + "\n");
		builder.append("\tunitOfRadius: " + this.getUnitOfRadius() + "\n");
		builder.append("\twaypointID: " + this.getWaypointID() + "\n");
		builder.append("}");
		return builder.toString();
	}
	private void toTable(){
		CommandTable ct = new CommandTable();
		ct.setShowVerticalLines(true);
		ct.setHeaders("Parameter","Value","Description");
		ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
		ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
		ct.addRow("arrivalCircleStatus", String.valueOf(this.getArrivalCircleStatus()), "");
		ct.addRow("perpendicularWaypointStatus", String.valueOf(this.getPerpendicularWaypointStatus()), "");
		ct.addRow("arrivalCircleRadius", String.valueOf(this.getArrivalCircleRadius()), "");
		ct.addRow("unitOfRadius", String.valueOf(this.getUnitOfRadius()), "");
		ct.addRow("waypointID", this.getWaypointID(), "");
		ct.print();
	}
}