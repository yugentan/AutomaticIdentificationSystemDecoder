package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class MSS {
    public MSS(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: MSS");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s) {
        String[] s = _s.split(",");
        try {
            setSignalStrength(s[1]);
            setSignalToNoiseRatio(s[2]);
            setBeaconFreq(s[3]);
            setBeaconBitRate(s[4]);
            setChannelNum(s[5].split("\\*")[0]);
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
    private String signalStrength;

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }

    public String getSignalToNoiseRatio() {
        return signalToNoiseRatio;
    }

    public void setSignalToNoiseRatio(String signalToNoiseRatio) {
        this.signalToNoiseRatio = signalToNoiseRatio;
    }

    public String getBeaconFreq() {
        return beaconFreq;
    }

    public void setBeaconFreq(String beaconFreq) {
        this.beaconFreq = beaconFreq;
    }

    public String getBeaconBitRate() {
        return beaconBitRate;
    }

    public void setBeaconBitRate(String beaconBitRate) {
        this.beaconBitRate = beaconBitRate;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum;
    }

    private String signalToNoiseRatio;
    private String beaconFreq;
    private String beaconBitRate;
    private String channelNum;
    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tSignalStrength: " + this.getSignalStrength() + "\n");
        builder.append("\tSignalToNoiseRatio: " + this.getSignalToNoiseRatio() +"\n");
        builder.append("\tBeaconFrequency: " + this.getBeaconFreq() + "\n");
        builder.append("\tBeaconBitRate: " + this.getBeaconBitRate()+ "\n");
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
        ct.addRow("Signal Strength", this.getSignalStrength(),"dB re: uV/m");
        ct.addRow("Signal To Noise Ratio", this.getSignalToNoiseRatio(), "dB");
        ct.addRow("Beacon Frequency", this.getBeaconFreq(),"283.5-325.0 kHz");
        ct.addRow("Beacon Bit Rate", this.getBeaconBitRate(),"per Seconds");
        ct.addRow("Channel Number", this.getChannelNum(),"");
        ct.print();
    }
}
