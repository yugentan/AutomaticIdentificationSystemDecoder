package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class LCD {
    public LCD(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: LCD");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setGri(s[1]);
            setMaster(s[2]);
            setMasterSignal(s[3]);
            setTd1(s[4]);
            setTd1s(s[5]);
            setTd2(s[6]);
            setTd2s(s[7]);
            setTd3(s[8]);
            setTd3s(s[9]);
            setTd4(s[10]);
            setTd4s(s[11]);
            setTd5(s[12]);
            setTd5s(s[13].split("\\*")[0]);
        } catch (Exception e) {
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
    private String master;
    private String masterSignal;
    private String td1;
    private String td1s;
    private String td2;
    private String td2s;
    private String td3;

    public String getGri() {
        return gri;
    }

    public void setGri(String gri) {
        this.gri = gri;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getMasterSignal() {
        return masterSignal;
    }

    public void setMasterSignal(String masterSignal) {
        this.masterSignal = masterSignal;
    }

    public String getTd1() {
        return td1;
    }

    public void setTd1(String td1) {
        this.td1 = td1;
    }

    public String getTd1s() {
        return td1s;
    }

    public void setTd1s(String td1s) {
        this.td1s = td1s;
    }

    public String getTd2() {
        return td2;
    }

    public void setTd2(String td2) {
        this.td2 = td2;
    }

    public String getTd2s() {
        return td2s;
    }

    public void setTd2s(String td2s) {
        this.td2s = td2s;
    }

    public String getTd3() {
        return td3;
    }

    public void setTd3(String td3) {
        this.td3 = td3;
    }

    public String getTd3s() {
        return td3s;
    }

    public void setTd3s(String td3s) {
        this.td3s = td3s;
    }

    public String getTd4() {
        return td4;
    }

    public void setTd4(String td4) {
        this.td4 = td4;
    }

    public String getTd4s() {
        return td4s;
    }

    public void setTd4s(String td4s) {
        this.td4s = td4s;
    }

    public String getTd5() {
        return td5;
    }

    public void setTd5(String td5) {
        this.td5 = td5;
    }

    public String getTd5s() {
        return td5s;
    }

    public void setTd5s(String td5s) {
        this.td5s = td5s;
    }

    private String td3s;
    private String td4;
    private String td4s;
    private String td5;
    private String td5s;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tGRIMicroseconds: " + this.getGri() + "\n");
        builder.append("\tMasterRelativeSNR: " + this.getMaster() + "\n");
        builder.append("\tMasterRelativeECD: " + this.getMasterSignal()+ "\n");
        builder.append("\tTimeDifference1Microseconds: " + this.getTd1() + "\n");
        builder.append("\tTimeDifference1SignalStatus: " + this.getTd1s()+ "\n");
        builder.append("\tTimeDifference2Microseconds: " + this.getTd2() + "\n");
        builder.append("\tTimeDifference2SignalStatus: " + this.getTd2s()+ "\n");
        builder.append("\tTimeDifference3Microseconds: " + this.getTd3() + "\n");
        builder.append("\tTimeDifference3SignalStatus: " + this.getTd3s()+ "\n");
        builder.append("\tTimeDifference4Microseconds: " + this.getTd4() + "\n");
        builder.append("\tTimeDifference4SignalStatus: " + this.getTd4s()+ "\n");
        builder.append("\tTimeDifference5Microseconds: " + this.getTd5() + "\n");
        builder.append("\tTimeDifference5SignalStatus: " + this.getTd5s()+ "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("GRI", this.getGri() ,"Microseconds/10");
        ct.addRow("Master Relative SNR", this.getMaster() ,"");
        ct.addRow("Master Relative ECD", this.getMasterSignal() ,"");
        ct.addRow("Time Difference 1", this.getTd1() ,"Microseconds");
        ct.addRow("Time Difference 1", this.getTd1s(),"Signal Status");
        ct.addRow("Time Difference 2", this.getTd2(),"Microseconds");
        ct.addRow("Time Difference 2", this.getTd2s(),"Signal Status");
        ct.addRow("Time Difference 3", this.getTd3(),"Microseconds");
        ct.addRow("Time Difference 3", this.getTd3s(),"Signal Status");
        ct.addRow("Time Difference 4", this.getTd4(),"Microseconds");
        ct.addRow("Time Difference 4", this.getTd4s(),"Signal Status");
        ct.addRow("Time Difference 5", this.getTd5(),"Microseconds");
        ct.addRow("Time Difference 5", this.getTd5s(),"Signal Status");
        ct.print();
    }
}
