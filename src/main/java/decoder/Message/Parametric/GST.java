package decoder.Message.Parametric;

import decoder.Binary.CommandTable;
import decoder.Binary.Describer;

public class GST {
    public GST(){};
    public void table(){
        try {
            this.toTable();
        }catch (Exception e){
            System.out.println("NULL EXPECTED IN TABLE: GST");
        }
    };    public void json(){
        System.out.println(this.toJson());
    }
    public void decode(String _s){
        String[] s = _s.split(",");
        try {
            setUtcFix(s[1]);
            setRmsStandardDeviation(s[2]);
            setSdvMajor(s[3]);
            setSdvMinor(s[4]);
            setOrientation(s[5]);
            setSdvLat(s[6]);
            setSdvLong(s[7]);
            setSdvAlt(s[8].split("\\*")[0]);
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
    private String utcFix;
    private String rmsStandardDeviation;
    private String sdvMajor;
    private String sdvMinor;
    private String orientation;
    private String sdvLat;
    private String sdvLong;
    private String sdvAlt;

    public String getUtcFix() {
        return utcFix;
    }

    public void setUtcFix(String utcFix) {
        this.utcFix = utcFix;
    }

    public String getRmsStandardDeviation() {
        return rmsStandardDeviation;
    }

    public void setRmsStandardDeviation(String rmsStandardDeviation) {
        this.rmsStandardDeviation = rmsStandardDeviation;
    }

    public String getSdvMajor() {
        return sdvMajor;
    }

    public void setSdvMajor(String sdvMajor) {
        this.sdvMajor = sdvMajor;
    }

    public String getSdvMinor() {
        return sdvMinor;
    }

    public void setSdvMinor(String sdvMinor) {
        this.sdvMinor = sdvMinor;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getSdvLat() {
        return sdvLat;
    }

    public void setSdvLat(String sdvLat) {
        this.sdvLat = sdvLat;
    }

    public String getSdvLong() {
        return sdvLong;
    }

    public void setSdvLong(String sdvLong) {
        this.sdvLong = sdvLong;
    }

    public String getSdvAlt() {
        return sdvAlt;
    }

    public void setSdvAlt(String sdvAlt) {
        this.sdvAlt = sdvAlt;
    }

    private String toJson(){
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tTalker: " + this.getTalker() + "\n");
        builder.append("\tFormat: " + this.getFormat() + "\n");
        builder.append("\tUTCTimeOfGGA/GNSFix: " + this.getUtcFix() + "\n");
        builder.append("\tRMSStandardDeviation: " + this.getRmsStandardDeviation() + "\n");
        builder.append("\tSDVSemiMajorErr: " + this.getSdvMajor() + "\n");
        builder.append("\tSDVSemiMinorErr: " + this.getSdvMinor() + "\n");
        builder.append("\tOrientationErr: " + this.getOrientation() + "\n");
        builder.append("\tSDVLatitudeErr: " + this.getSdvLat() + "\n");
        builder.append("\tSDVLongitudeErr: " + this.getSdvLong() + "\n");
        builder.append("\tSDVAltitudeErr: " + this.getSdvAlt() + "\n");
        builder.append("}");
        return builder.toString();
    }
    private void toTable(){
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Talker", this.getTalker(), Describer.describeTalker(this.getTalker()));
        ct.addRow("Format", this.getFormat(), Describer.describeFormat(this.getFormat()));
        ct.addRow("UTC time of associated GGA fix", this.getUtcFix(),"hhmmss.ss");
        ct.addRow("Total RMS standard deviation", this.getRmsStandardDeviation(),"");
        ct.addRow("Standard deviation of semi-major axis of error ellipse", this.getSdvMajor(),"meters");
        ct.addRow("Standard deviation of semi-minor axis of error ellipse", this.getSdvMinor(),"meters");
        ct.addRow("Orientation of semi-major axis of error ellipse", this.getOrientation(),"degrees from true north");
        ct.addRow("Standard deviation of latitude error", this.getSdvLat(),"meters");
        ct.addRow("Standard deviation of longitude error", this.getSdvLong(),"meters");
        ct.addRow("Standard deviation of altitude error", this.getSdvAlt(),"meters");
        ct.print();
    }
}
