package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
//OBS
public class GLC {
    public GLC(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GLC");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setGri(s[1]);
            setMasterTOA(s[2] + " " + s[3]);
            setTd1(s[4] + " " + s[5]);
            setTd2(s[6]);
            setTd2Status(s[7]);
            setTd3(s[8]);
            setTd3Status(s[9]);
            setTd4(s[10]);
            setTd4Status(s[11]);
            setTd5(s[12]);
            setSignalStatus(s[13]);
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
    private String gri;
    private String masterTOA;
    private String td1;
    private String td2;
    private String td2Status;
    private String td3;
    private String td3Status;
    private String td4;
    private String td4Status;
    private String td5;

    public String getGri() {
        return gri;
    }

    public void setGri(String gri) {
        this.gri = gri;
    }

    public String getMasterTOA() {
        return masterTOA;
    }

    public void setMasterTOA(String masterTOA) {
        this.masterTOA = masterTOA;
    }

    public String getTd1() {
        return td1;
    }

    public void setTd1(String td1) {
        this.td1 = td1;
    }

    public String getTd2() {
        return td2;
    }

    public void setTd2(String td2) {
        this.td2 = td2;
    }

    public String getTd2Status() {
        return td2Status;
    }

    public void setTd2Status(String td2Status) {
        this.td2Status = td2Status;
    }

    public String getTd3() {
        return td3;
    }

    public void setTd3(String td3) {
        this.td3 = td3;
    }

    public String getTd3Status() {
        return td3Status;
    }

    public void setTd3Status(String td3Status) {
        this.td3Status = td3Status;
    }

    public String getTd4() {
        return td4;
    }

    public void setTd4(String td4) {
        this.td4 = td4;
    }

    public String getTd4Status() {
        return td4Status;
    }

    public void setTd4Status(String td4Status) {
        this.td4Status = td4Status;
    }

    public String getTd5() {
        return td5;
    }

    public void setTd5(String td5) {
        this.td5 = td5;
    }





    public String getSignalStatus() {
        return signalStatus;
    }

    public void setSignalStatus(String signalStatus) {
        this.signalStatus = signalStatus;
    }

    private String signalStatus;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tGRI: " + this.getGri() + "\n");
        builder.append("\tMasterTOA: " + this.getMasterTOA() + "\n");
        builder.append("\tTD1: " + this.getTd1() + "\n");
        builder.append("\tTD2: " + this.getTd2() + " " + this.getTd2Status()+ "\n");
        builder.append("\tTD3: " + this.getTd3() + " " + this.getTd3Status()+ "\n");
        builder.append("\tTD4: " + this.getTd4() + " " + this.getTd4Status()+ "\n");
        builder.append("\tTD5: " + this.getTd5() + "\n");
        builder.append("\tSignalStatus: " + this.getSignalStatus() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("GRI", this.getGri() ,"tens of microseconds");
        ct.addRow("Master TOA", this.getMasterTOA(),"microseconds");
        ct.addRow("TD1", this.getTd1(),"microseconds");
        ct.addRow("TD2", this.getTd2(),this.getTd2Status());
        ct.addRow("TD3", this.getTd3(),this.getTd3Status());
        ct.addRow("TD4", this.getTd4(),this.getTd4Status());
        ct.addRow("TD5", this.getTd5(),"");
        ct.addRow("Signal Status, in order of priority", this.getSignalStatus(), Describer.describeSignalStatus(this.getSignalStatus()));

        ct.print();
    }
}
