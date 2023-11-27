package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class MSK {
    public MSK(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: MSK");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setBeaconFreq(s[1]);
            setAutoManualFreq(s[2]);
            setBeaconBitrate(s[3]);
            setAutoManualBitrate(s[4]);
            setInterval(s[5]);
            setChannelNum(s[6].split("\\*")[0]);
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
    private String beaconFreq;
    private String autoManualFreq;
    private String beaconBitrate;
    private String autoManualBitrate;
    private String interval;
    private String channelNum;

    public String getBeaconFreq() {
        return beaconFreq;
    }

    public void setBeaconFreq(String beaconFreq) {
        this.beaconFreq = beaconFreq;
    }

    public String getAutoManualFreq() {
        return autoManualFreq;
    }

    public void setAutoManualFreq(String autoManualFreq) {
        this.autoManualFreq = autoManualFreq;
    }

    public String getBeaconBitrate() {
        return beaconBitrate;
    }

    public void setBeaconBitrate(String beaconBitrate) {
        this.beaconBitrate = beaconBitrate;
    }

    public String getAutoManualBitrate() {
        return autoManualBitrate;
    }

    public void setAutoManualBitrate(String autoManualBitrate) {
        this.autoManualBitrate = autoManualBitrate;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum;
    }

    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tBeaconFrequency: " + this.getBeaconFreq() + "\n");
        builder.append("\tAutoManualFrequency: " + this.getAutoManualFreq()+ "\n");
        builder.append("\tBeaconBitRate: " + this.getBeaconBitrate() + "\n");
        builder.append("\tAutoManualBitRate: " + this.getAutoManualBitrate() + "\n");
        builder.append("\tInterval: " + this.getInterval() + "\n");
        builder.append("\tChannelNumber: " + this.getChannelNum() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("Beacon Frequency", this.getBeaconFreq(), "283.5-325.0 kHz");
        ct.addRow("Auto/Manual Frequency", this.getAutoManualFreq(), "A/M^2");
        ct.addRow("Beacon Bit Rate", this.getBeaconBitrate(), "per seconds");
        ct.addRow("Auto/Manual Frequency", this.getAutoManualBitrate(), "A/M^2");
        ct.addRow("Interval for sending", this.getInterval(), "seconds");
        ct.addRow("Channel number", this.getChannelNum(), "");
        ct.print();
    }
}
