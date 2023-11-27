package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
//NEED MORE RESEARCH
public class DSC {
    public DSC(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: BOD");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setFormatSpecifier(s[1]);
            setAddress(s[2]);
            setCategory(s[3]);
            setNatureDistress(s[4]);
            setTypeOfCommunication(s[5]);
            setPositionOrChannelFrequency(s[6]);
            setTimeOrTelNumb(s[7]);
            setMMSIDistress(s[8]);
            setNatureOfDistress(s[9]);
            setAck(s[10].charAt(0));
            setExpansionIndicator(s[11].charAt(0));
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
    private String formatSpecifier;
    private String address;
    private String category;
    private String natureOfDistress;
    private String typeOfCommunication;
    private String positionOrChannelFrequency;
    private String timeOrTelNumb;
    private String MMSIDistress;

    public String getFormatSpecifier() {
        return formatSpecifier;
    }

    public void setFormatSpecifier(String formatSpecifier) {
        this.formatSpecifier = formatSpecifier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNatureOfDistress() {
        return natureOfDistress;
    }

    public void setNatureOfDistress(String natureOfDistress) {
        this.natureOfDistress = natureOfDistress;
    }

    public String getTypeOfCommunication() {
        return typeOfCommunication;
    }

    public void setTypeOfCommunication(String typeOfCommunication) {
        this.typeOfCommunication = typeOfCommunication;
    }

    public String getPositionOrChannelFrequency() {
        return positionOrChannelFrequency;
    }

    public void setPositionOrChannelFrequency(String positionOrChannelFrequency) {
        this.positionOrChannelFrequency = positionOrChannelFrequency;
    }

    public String getTimeOrTelNumb() {
        return timeOrTelNumb;
    }

    public void setTimeOrTelNumb(String timeOrTelNumb) {
        this.timeOrTelNumb = timeOrTelNumb;
    }

    public String getMMSIDistress() {
        return MMSIDistress;
    }

    public void setMMSIDistress(String MMSIDistress) {
        this.MMSIDistress = MMSIDistress;
    }

    public String getNatureDistress() {
        return NatureDistress;
    }

    public void setNatureDistress(String natureDistress) {
        NatureDistress = natureDistress;
    }

    public char getAck() {
        return ack;
    }

    public void setAck(char ack) {
        this.ack = ack;
    }

    public char getExpansionIndicator() {
        return expansionIndicator;
    }

    public void setExpansionIndicator(char expansionIndicator) {
        this.expansionIndicator = expansionIndicator;
    }

    private String NatureDistress;
    private char ack;
    private char expansionIndicator;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tFormatSpecifier: " + this.getFormatSpecifier() + "\n");
        builder.append("\tAddress: " + this.getAddress()+ "\n");
        builder.append("\tCategory: " + this.getCategory() + "\n");
        builder.append("\tNatureOfDistressOrFirstTelCommand: " + this.getNatureDistress() + "\n");
        builder.append("\tTypeOfCommunication: " + this.getTypeOfCommunication() + "\n");
        builder.append("\tPositionOrChannelFrequency: " + this.getPositionOrChannelFrequency() + "\n");
        builder.append("\tTimeOrTelNumber: " + this.getTimeOrTelNumb() + "\n");
        builder.append("\tMMSIOfDistress: " + this.getMMSIDistress() + "\n");
        builder.append("\tNatureOfDistress: " + this.getNatureOfDistress() + "\n");
        builder.append("\tAcknowledgement: " + this.getAck() + "\n");
        builder.append("\tExpansionIndicator: " + this.getExpansionIndicator() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Format Specifier", this.getFormatSpecifier() ,"");
        ct.addRow("Address", this.getAddress() ,"");
        ct.addRow("Category", this.getCategory() ,"");
        ct.addRow("Nature of Distress or First Telecommand", this.getNatureDistress() ,"");
        ct.addRow("Type of Communication or Second Telecommand", this.getTypeOfCommunication(),"");
        ct.addRow("Position or Channel/Frequency", this.getPositionOrChannelFrequency() ,"");
        ct.addRow("Time or Tel. No.", this.getTimeOrTelNumb(),"UTC hhmm (hours and minutes)");
        ct.addRow("MMSI of ship in distress", this.getMMSIDistress(),"");
        ct.addRow("Nature of Distress", this.getNatureOfDistress() ,Describer.describeDistress(this.getNatureDistress()));
        ct.addRow("Acknowledgement",String.valueOf(this.getAck()), Describer.describeAck(this.getAck()));
        ct.addRow("Expansion Indicator", String.valueOf(this.getExpansionIndicator()) ,Describer.describeExpansion(this.getExpansionIndicator()));
        ct.print();
    }

}
