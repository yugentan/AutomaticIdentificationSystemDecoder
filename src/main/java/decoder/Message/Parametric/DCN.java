package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
//OBS
public class DCN {
    public DCN(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: DCN");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setDeccaChainIdentifier(s[1]);
            setRedZoneIdentifier(s[2]);
            setRedLineOfPosition(s[3]);
            setRedMasterLineStatus(s[4]);
            setGreenZoneIdentifier(s[5]);
            setGreenLineOfPosition(s[6]);
            setGreenMasterLineStatus(s[7]);
            setPurpleZoneIdentifier(s[8]);
            setPurpleLineOfPosition(s[9]);
            setPurpleMasterLineStatus(s[10]);
            setRedLineNavigationUse(s[11]);
            setGreenLineNavigationUse(s[12]);
            setPurpleLineNavigationUse(s[13]);
            setPositionUncertainty(s[14] + " " + s[15]);
            setFixDataBasis(Integer.parseInt(s[16].split("\\*")[0]));
        }catch (Exception e){
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

    public String getDeccaChainIdentifier() {
        return deccaChainIdentifier;
    }

    public void setDeccaChainIdentifier(String deccaChainIdentifier) {
        this.deccaChainIdentifier = deccaChainIdentifier;
    }

    public String getRedZoneIdentifier() {
        return redZoneIdentifier;
    }

    public void setRedZoneIdentifier(String redZoneIdentifier) {
        this.redZoneIdentifier = redZoneIdentifier;
    }

    public String getRedLineOfPosition() {
        return redLineOfPosition;
    }

    public void setRedLineOfPosition(String redLineOfPosition) {
        this.redLineOfPosition = redLineOfPosition;
    }

    public String getRedMasterLineStatus() {
        return redMasterLineStatus;
    }

    public void setRedMasterLineStatus(String redMasterLineStatus) {
        this.redMasterLineStatus = redMasterLineStatus;
    }

    public String getGreenZoneIdentifier() {
        return greenZoneIdentifier;
    }

    public void setGreenZoneIdentifier(String greenZoneIdentifier) {
        this.greenZoneIdentifier = greenZoneIdentifier;
    }

    public String getGreenLineOfPosition() {
        return greenLineOfPosition;
    }

    public void setGreenLineOfPosition(String greenLineOfPosition) {
        this.greenLineOfPosition = greenLineOfPosition;
    }

    public String getGreenMasterLineStatus() {
        return greenMasterLineStatus;
    }

    public void setGreenMasterLineStatus(String greenMasterLineStatus) {
        this.greenMasterLineStatus = greenMasterLineStatus;
    }

    public String getPurpleZoneIdentifier() {
        return purpleZoneIdentifier;
    }

    public void setPurpleZoneIdentifier(String purpleZoneIdentifier) {
        this.purpleZoneIdentifier = purpleZoneIdentifier;
    }

    public String getPurpleLineOfPosition() {
        return purpleLineOfPosition;
    }

    public void setPurpleLineOfPosition(String purpleLineOfPosition) {
        this.purpleLineOfPosition = purpleLineOfPosition;
    }

    public String getPurpleMasterLineStatus() {
        return purpleMasterLineStatus;
    }

    public void setPurpleMasterLineStatus(String purpleMasterLineStatus) {
        this.purpleMasterLineStatus = purpleMasterLineStatus;
    }

    public String getRedLineNavigationUse() {
        return redLineNavigationUse;
    }

    public void setRedLineNavigationUse(String redLineNavigationUse) {
        this.redLineNavigationUse = redLineNavigationUse;
    }

    public String getGreenLineNavigationUse() {
        return greenLineNavigationUse;
    }

    public void setGreenLineNavigationUse(String greenLineNavigationUse) {
        this.greenLineNavigationUse = greenLineNavigationUse;
    }

    public String getPurpleLineNavigationUse() {
        return purpleLineNavigationUse;
    }

    public void setPurpleLineNavigationUse(String purpleLineNavigationUse) {
        this.purpleLineNavigationUse = purpleLineNavigationUse;
    }

    public String getPositionUncertainty() {
        return positionUncertainty;
    }

    public void setPositionUncertainty(String positionUncertainty) {
        this.positionUncertainty = positionUncertainty;
    }

    public int getFixDataBasis() {
        return fixDataBasis;
    }

    public void setFixDataBasis(int fixDataBasis) {
        this.fixDataBasis = fixDataBasis;
    }

    private String deccaChainIdentifier;
    private String redZoneIdentifier;
    private String redLineOfPosition;
    private String redMasterLineStatus;
    private String greenZoneIdentifier;
    private String greenLineOfPosition;
    private String greenMasterLineStatus;
    private String purpleZoneIdentifier;
    private String purpleLineOfPosition;
    private String purpleMasterLineStatus;
    private String redLineNavigationUse;
    private String greenLineNavigationUse;
    private String purpleLineNavigationUse;
    private String positionUncertainty;
    private int fixDataBasis;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tDeccaChainIdentifier: " + this.getDeccaChainIdentifier() + "\n");
        builder.append("\tRedZoneIdentifier: " + this.getRedZoneIdentifier() + "\n");
        builder.append("\tRedLineOfPosition: " + this.getRedLineOfPosition() + "\n");
        builder.append("\tRedMasterLine: " + this.getRedMasterLineStatus() + "\n");
        builder.append("\tGreenZoneIdentifier: " + this.getGreenZoneIdentifier() + "\n");
        builder.append("\tGreenLineOfPosition: " + this.getGreenLineOfPosition() + "\n");
        builder.append("\tGreenMasterLine: " + this.getGreenMasterLineStatus() + "\n");
        builder.append("\tPurpleZoneIdentifier: " + this.getPurpleZoneIdentifier() + "\n");
        builder.append("\tPurpleLineOfPosition: " + this.getPurpleLineOfPosition() + "\n");
        builder.append("\tPurpleMasterLine: " + this.getPurpleMasterLineStatus()+ "\n");
        builder.append("\tRedLineNavigationUse: " + this.getRedLineNavigationUse() + "\n");
        builder.append("\tGreenLineNavigationUse: " + this.getGreenLineNavigationUse() + "\n");
        builder.append("\tPurpleLineNavigationUse: " + this.getPurpleLineNavigationUse() + "\n");
        builder.append("\tPositionUncertainty: " + this.getPositionUncertainty() + "\n");
        builder.append("\tFixDataBasis: " + this.getFixDataBasis() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Decca Chain Identifier", this.getDeccaChainIdentifier() , "");
        ct.addRow("Red Zone Identifier", this.getRedZoneIdentifier() , "number-letter");
        ct.addRow("Red Line of Position", this.getRedLineOfPosition(), "");
        ct.addRow("Red Master Line", this.getRedMasterLineStatus() , Describer.describeCurrentData(this.getRedMasterLineStatus().charAt(0)));
        ct.addRow("Green Zone Identifier", this.getGreenZoneIdentifier() , "number-letter");
        ct.addRow("Green Line of Position", this.getGreenLineOfPosition(), "");
        ct.addRow("Green Master Line", this.getGreenMasterLineStatus() , Describer.describeCurrentData(this.getGreenMasterLineStatus().charAt(0)));
        ct.addRow("Purple Zone Identifier", this.getPurpleZoneIdentifier() , "number-letter");
        ct.addRow("Purple Line of Position", this.getPurpleLineOfPosition(), "");
        ct.addRow("Purple Master Line", this.getPurpleMasterLineStatus() , Describer.describeCurrentData(this.getPurpleMasterLineStatus().charAt(0)));
        ct.addRow("Red-Line Navigation Status", this.getRedLineNavigationUse(), Describer.describeCurrentData(this.getRedLineNavigationUse().charAt(0)));
        ct.addRow("Green-Line Navigation Status", this.getGreenLineNavigationUse(), Describer.describeCurrentData(this.getGreenLineNavigationUse().charAt(0)));
        ct.addRow("Purple-Line Navigation Status", this.getPurpleLineNavigationUse(), Describer.describeCurrentData(this.getPurpleLineNavigationUse().charAt(0)));
        ct.addRow("Position Uncertainty", this.getPositionUncertainty(), "Nautical Miles");
        ct.addRow("Fix Data Basis", String.valueOf(this.getFixDataBasis()) , Describer.describeFixDataBasis(this.getFixDataBasis()));
        ct.print();
    }
}
