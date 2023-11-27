package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class GSA {
    public GSA(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GSA");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setSelectionMode(s[1]);
            setMode(s[2]);
            setId1(s[3]);
            setId2(s[4]);
            setId3(s[5]);
            setId4(s[6]);
            setId5(s[7]);
            setId6(s[8]);
            setId7(s[9]);
            setId8(s[10]);
            setId9(s[11]);
            setId10(s[12]);
            setId11(s[13]);
            setId12(s[14]);
            setPdop(s[15]);
            setHdop(s[16]);
            setVdop(s[17].split("\\*")[0]);
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
    private String selectionMode;
    private String mode;
    private String id1;
    private String id2;
    private String id3;
    private String id4;
    private String id5;
    private String id6;

    public String getSelectionMode() {
        return selectionMode;
    }

    public void setSelectionMode(String selectionMode) {
        this.selectionMode = selectionMode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getId3() {
        return id3;
    }

    public void setId3(String id3) {
        this.id3 = id3;
    }

    public String getId4() {
        return id4;
    }

    public void setId4(String id4) {
        this.id4 = id4;
    }

    public String getId5() {
        return id5;
    }

    public void setId5(String id5) {
        this.id5 = id5;
    }

    public String getId6() {
        return id6;
    }

    public void setId6(String id6) {
        this.id6 = id6;
    }

    public String getId7() {
        return id7;
    }

    public void setId7(String id7) {
        this.id7 = id7;
    }

    public String getId8() {
        return id8;
    }

    public void setId8(String id8) {
        this.id8 = id8;
    }

    public String getId9() {
        return id9;
    }

    public void setId9(String id9) {
        this.id9 = id9;
    }

    public String getId10() {
        return id10;
    }

    public void setId10(String id10) {
        this.id10 = id10;
    }

    public String getId11() {
        return id11;
    }

    public void setId11(String id11) {
        this.id11 = id11;
    }

    public String getId12() {
        return id12;
    }

    public void setId12(String id12) {
        this.id12 = id12;
    }

    public String getPdop() {
        return pdop;
    }

    public void setPdop(String pdop) {
        this.pdop = pdop;
    }

    public String getHdop() {
        return hdop;
    }

    public void setHdop(String hdop) {
        this.hdop = hdop;
    }

    public String getVdop() {
        return vdop;
    }

    public void setVdop(String vdop) {
        this.vdop = vdop;
    }

    private String id7;
    private String id8;
    private String id9;
    private String id10;
    private String id11;
    private String id12;
    private String pdop;
    private String hdop;
    private String vdop;


    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tSelectionMode: " + this.getSelectionMode()+"\n");
        builder.append("\tMode: " + this.getMode() +"\n");
        builder.append("\tSatelliteID1: " + this.getId1() +"\n");
        builder.append("\tSatelliteID2: " + this.getId2() +"\n");
        builder.append("\tSatelliteID3: " + this.getId3() +"\n");
        builder.append("\tSatelliteID4: " + this.getId4() +"\n");
        builder.append("\tSatelliteID5: " + this.getId5() +"\n");
        builder.append("\tSatelliteID6: " + this.getId6() +"\n");
        builder.append("\tSatelliteID7: " + this.getId7() +"\n");
        builder.append("\tSatelliteID8: " + this.getId8() +"\n");
        builder.append("\tSatelliteID9: " + this.getId9() +"\n");
        builder.append("\tSatelliteID10: " + this.getId10() +"\n");
        builder.append("\tSatelliteID11: " + this.getId11() +"\n");
        builder.append("\tSatelliteID12: " + this.getId12() +"\n");
        builder.append("\tPDOP: " + this.getPdop() +"\n");
        builder.append("\tHDOP: " + this.getHdop() +"\n");
        builder.append("\tVDOP: " + this.getVdop() +"\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Selection mode", this.getSelectionMode(), Describer.describeSelectionMode(this.getSelectionMode()));
        ct.addRow("Mode", this.getMode(), Describer.describeGSAMode(this.getMode()));
        ct.addRow("ID of 1st satellite used for fix", this.getId1(), "");
        ct.addRow("ID of 2nd satellite used for fix", this.getId2(), "");
        ct.addRow("ID of 3rd satellite used for fix", this.getId3(), "");
        ct.addRow("ID of 4th satellite used for fix", this.getId4(), "");
        ct.addRow("ID of 5th satellite used for fix", this.getId5(), "");
        ct.addRow("ID of 6th satellite used for fix", this.getId6(), "");
        ct.addRow("ID of 7th satellite used for fix", this.getId7(), "");
        ct.addRow("ID of 8th satellite used for fix", this.getId8(), "");
        ct.addRow("ID of 9th satellite used for fix", this.getId9(), "");
        ct.addRow("ID of 10th satellite used for fix", this.getId10(), "");
        ct.addRow("ID of 11th satellite used for fix", this.getId11(), "");
        ct.addRow("ID of 12th satellite used for fix", this.getId12(), "");
        ct.addRow("PDOP", this.getPdop(), "");
        ct.addRow("HDOP", this.getHdop(), "");
        ct.addRow("VDOP", this.getVdop(), "");
        ct.print();
    }
}
