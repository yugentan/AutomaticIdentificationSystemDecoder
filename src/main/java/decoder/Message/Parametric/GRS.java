package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class GRS {
    public GRS(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GRS");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setUtcTime(s[1]);
            setMode(s[2]);
            setSatellite1Res(s[3]);
            setSatellite2Res(s[4]);
            setSatellite3Res(s[5]);
            setSatellite4Res(s[6]);
            setSatellite5Res(s[7]);
            setSatellite6Res(s[8]);
            setSatellite7Res(s[9]);
            setSatellite8Res(s[10]);
            setSatellite9Res(s[11]);
            setSatellite10Res(s[12]);
            setSatellite11Res(s[13]);
            setSatellite12Res(s[14].split("\\*")[0]);
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
    private String utcTime;
    private String mode;
    private String satellite1Res;
    private String satellite2Res;
    private String satellite3Res;

    public String getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSatellite1Res() {
        return satellite1Res;
    }

    public void setSatellite1Res(String satellite1Res) {
        this.satellite1Res = satellite1Res;
    }

    public String getSatellite2Res() {
        return satellite2Res;
    }

    public void setSatellite2Res(String satellite2Res) {
        this.satellite2Res = satellite2Res;
    }

    public String getSatellite3Res() {
        return satellite3Res;
    }

    public void setSatellite3Res(String satellite3Res) {
        this.satellite3Res = satellite3Res;
    }

    public String getSatellite4Res() {
        return satellite4Res;
    }

    public void setSatellite4Res(String satellite4Res) {
        this.satellite4Res = satellite4Res;
    }

    public String getSatellite5Res() {
        return satellite5Res;
    }

    public void setSatellite5Res(String satellite5Res) {
        this.satellite5Res = satellite5Res;
    }

    public String getSatellite6Res() {
        return satellite6Res;
    }

    public void setSatellite6Res(String satellite6Res) {
        this.satellite6Res = satellite6Res;
    }

    public String getSatellite7Res() {
        return satellite7Res;
    }

    public void setSatellite7Res(String satellite7Res) {
        this.satellite7Res = satellite7Res;
    }

    public String getSatellite8Res() {
        return satellite8Res;
    }

    public void setSatellite8Res(String satellite8Res) {
        this.satellite8Res = satellite8Res;
    }

    public String getSatellite9Res() {
        return satellite9Res;
    }

    public void setSatellite9Res(String satellite9Res) {
        this.satellite9Res = satellite9Res;
    }

    public String getSatellite10Res() {
        return satellite10Res;
    }

    public void setSatellite10Res(String satellite10Res) {
        this.satellite10Res = satellite10Res;
    }

    public String getSatellite11Res() {
        return satellite11Res;
    }

    public void setSatellite11Res(String satellite11Res) {
        this.satellite11Res = satellite11Res;
    }

    public String getSatellite12Res() {
        return satellite12Res;
    }

    public void setSatellite12Res(String satellite12Res) {
        this.satellite12Res = satellite12Res;
    }

    private String satellite4Res;
    private String satellite5Res;
    private String satellite6Res;
    private String satellite7Res;
    private String satellite8Res;
    private String satellite9Res;
    private String satellite10Res;
    private String satellite11Res;
    private String satellite12Res;

    private String talker;
    private String format;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tUTCTime: " +this.getUtcTime()+ "\n");
        builder.append("\tMode: " +this.getMode()+ "\n");
        builder.append("\tSatellite1Residual: " +this.getSatellite1Res()+ "\n");
        builder.append("\tSatellite2Residual: " +this.getSatellite2Res()+ "\n");
        builder.append("\tSatellite3Residual: " +this.getSatellite3Res()+ "\n");
        builder.append("\tSatellite4Residual: " +this.getSatellite4Res()+ "\n");
        builder.append("\tSatellite5Residual: " +this.getSatellite5Res()+ "\n");
        builder.append("\tSatellite6Residual: " +this.getSatellite6Res()+ "\n");
        builder.append("\tSatellite7Residual: " +this.getSatellite7Res()+ "\n");
        builder.append("\tSatellite8Residual: " +this.getSatellite8Res()+ "\n");
        builder.append("\tSatellite9Residual: " +this.getSatellite9Res()+ "\n");
        builder.append("\tSatellite10Residual: " +this.getSatellite10Res()+ "\n");
        builder.append("\tSatellite11Residual: " +this.getSatellite11Res()+ "\n");
        builder.append("\tSatellite12Residual: " +this.getSatellite12Res()+ "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("UTC time of the GGA or GNS fix", this.getUtcTime(),"HHMMSS.SS");
        ct.addRow("Mode", this.getMode(),"");
        ct.addRow("Satellite 1 residual", this.getSatellite1Res() ,"meters");
        ct.addRow("Satellite 2 residual", this.getSatellite2Res(),"meters");
        ct.addRow("Satellite 3 residual", this.getSatellite3Res(),"meters");
        ct.addRow("Satellite 4 residual", this.getSatellite4Res(),"meters");
        ct.addRow("Satellite 5 residual", this.getSatellite5Res(),"meters");
        ct.addRow("Satellite 6 residual", this.getSatellite6Res(),"meters");
        ct.addRow("Satellite 7 residual", this.getSatellite7Res(),"meters");
        ct.addRow("Satellite 8 residual", this.getSatellite8Res(),"meters");
        ct.addRow("Satellite 9 residual", this.getSatellite9Res(),"meters");
        ct.addRow("Satellite 10 residual", this.getSatellite10Res(),"meters");
        ct.addRow("Satellite 11 residual", this.getSatellite11Res(),"meters");
        ct.addRow("Satellite 12 residual", this.getSatellite12Res(),"meters");
        ct.print();
    }
}
