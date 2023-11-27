package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class ACS {
    public ACS(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: ACS");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setSequenceNumber(Integer.parseInt(s[1]));
            setOriginatorMMSI(Integer.parseInt(s[2]));
            setUtcReceipt(s[3]);
            setUtcDay(s[4]);
            setUtcMonth(s[5]);
            setUtcYear(s[6].split("\\*")[0]);
        }catch (Exception e){
            System.out.println("Sentence: " + _s + " contains invalid fields");
        }
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public int getOriginatorMMSI() {
        return originatorMMSI;
    }

    public void setOriginatorMMSI(int originatorMMSI) {
        this.originatorMMSI = originatorMMSI;
    }

    public String getUtcReceipt() {
        return utcReceipt;
    }

    public void setUtcReceipt(String utcReceipt) {
        this.utcReceipt = utcReceipt;
    }

    public String getUtcDay() {
        return utcDay;
    }

    public void setUtcDay(String utcDay) {
        this.utcDay = utcDay;
    }

    public String getUtcMonth() {
        return utcMonth;
    }

    public void setUtcMonth(String utcMonth) {
        this.utcMonth = utcMonth;
    }

    public String getUtcYear() {
        return utcYear;
    }

    public void setUtcYear(String utcYear) {
        this.utcYear = utcYear;
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

    private int sequenceNumber;
    private int originatorMMSI;
    private String utcReceipt;
    private String utcDay;
    private String utcMonth;
    private String utcYear;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tSequenceNumber: " + this.getSequenceNumber() + "\n");
        builder.append("\tOriginatorMMSI: " + this.getOriginatorMMSI() + "\n");
        builder.append("UTCReceiptOfChannelManagementInformation: " + this.getUtcReceipt() + "\n");
        builder.append("UTCDay: " + this.getUtcDay() + "\n");
        builder.append("UTCMonth: " + this.getUtcMonth() + "\n");
        builder.append("UTCYear: " + this.getUtcYear() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable() {
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Sequence Number", String.valueOf(this.getSequenceNumber()), "");
        ct.addRow("Originator MMSI", String.valueOf(this.getOriginatorMMSI()), "");
        ct.addRow("UTC of receipt of channel management information", this.getUtcReceipt(), "");
        ct.addRow("UTC Day", this.getUtcDay(), "");
        ct.addRow("UTC Month", this.getUtcMonth(), "");
        ct.addRow("UTC Year", this.getUtcYear(), "");
        ct.print();
    }
}
