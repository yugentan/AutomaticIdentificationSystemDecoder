package decoder.Message.Types;

import decoder.Binary.Binary;
import decoder.Binary.CommandTable;
import decoder.Binary.Describer;
import decoder.Message.Encapsulated.Emessage;

public class Message6 extends Emessage {
    public Message6() {
    }

    ;

    public void run(Emessage e) {
        setBitmap(e.getBitmap());
        this.setCommonField(e);
        this.assignFields();
    }

    public void json() {
        System.out.println(this.toJson());
    }

    public void table() {
        try {
            this.toTable();
        } catch (Exception e) {
            System.out.println("NULL EXPECTED IN TABLE: BOD");
        }
    }

    ;

    public void setCommonField(Emessage e) {
        this.setRepeater(e.getRepeater());
        this.setMsgId(e.getMsgId());
        this.setMMSI(e.getMMSI());
    }

    /**
     * Setters
     */
    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public void setDestinationMMSI(int destinationMMSI) {
        this.destinationMMSI = destinationMMSI;
    }

    public void setRetransmit(int retransmit) {
        this.retransmit = retransmit;
    }

    public void setSpare(int spare) {
        this.spare = spare;
    }

    public void setDac(int dac) {
        this.dac = dac;
    }

    public void setFi(int fi) {
        this.fi = fi;
    }

    /**
     * Getters
     */
    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public int getDestinationMMSI() {
        return this.destinationMMSI;
    }

    public int getRetransmit() {
        return this.retransmit;
    }

    public int getSpare() {
        return this.spare;
    }

    public int getDac() {
        return this.dac;
    }

    public int getFi() {
        return this.fi;
    }

    private void assignFields() {
        this.assignSequenceNumber();
        this.assignDestinationMMSI();
        this.assignRetransmit();
        this.assignSpare();
        this.assignDAC();
        this.assignFI();
    }

    private void assignSequenceNumber() {
        String sequenceString = "";
        try {
            for (int i = 0; i < sequenceNumberCount; i++) {
                sequenceString += bitmap.toCharArray()[i + sequenceNumberPtr];
            }
            setSequenceNumber(Binary.convertToDec(sequenceString));
        } catch (Exception e) {
            setSequenceNumber(0);
        }
    }

    private void assignDestinationMMSI() {
        String destinationMMSIString = "";
        try {
            for (int i = 0; i < destinationIDCount; i++) {
                destinationMMSIString += bitmap.toCharArray()[i + destinationIDPtr];
            }
            setDestinationMMSI(Binary.convertToDec(destinationMMSIString));
        } catch (Exception e) {
            setDestinationMMSI(0);
        }
    }

    private void assignRetransmit() {
        String retransmitString = "";
        try {
            for (int i = 0; i < retransmitCount; i++) {
                retransmitString += bitmap.toCharArray()[i + retransmitPtr];
            }
            setRetransmit(Binary.convertToDec(retransmitString));
        } catch (Exception e) {
            setRetransmit(0);
        }
    }

    private void assignSpare() {
        String spareString = "";
        try {
            for (int i = 0; i < spareCount; i++) {
                spareString += bitmap.toCharArray()[i + sparePtr];
            }
            setSpare(Binary.convertToDec(spareString));
        } catch (Exception e) {
            setSpare(0);
        }
    }

    private void assignDAC() {
        String dacString = "";
        try {
            for (int i = 0; i < dacCount; i++) {
                dacString += bitmap.toCharArray()[i + dacPtr];
            }
            setDac(Binary.convertToDec(dacString));
        } catch (Exception e) {
            setDac(0);
        }
    }

    private void assignFI() {
        String fiString = "";
        try {
            for (int i = 0; i < fiCount; i++) {
                fiString += bitmap.toCharArray()[i + fiPtr];
            }
            setFi(Binary.convertToDec(fiString));
        } catch (Exception e) {
            setFi(0);
        }
    }

    private int sequenceNumber;
    private int destinationMMSI;
    private int retransmit;
    private int spare;
    private int dac;
    private int fi;
    final int sequenceNumberPtr = 38, sequenceNumberCount = 2;
    final int destinationIDPtr = 40, destinationIDCount = 30;
    final int retransmitPtr = 70, retransmitCount = 1;
    final int sparePtr = 71, spareCount = 1;
    final int dacPtr = 72, dacCount = 10;
    final int fiPtr = 82, fiCount = 6;
    //APPLICATION STARTS 88;
    private String bitmap = "";

    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("Result: {\n");
        builder.append("\tMessageID: " + this.getMsgId() + "\n");
        builder.append("\tRepeater: " + this.getRepeater() + "\n");
        builder.append("\tMMSI: " + this.getMMSI() + "\n");
        builder.append("\tSequenceNumber: " + this.getSequenceNumber() + "\n");
        builder.append("\tDestinationMMSI: " + this.getDestinationMMSI() + "\n");
        builder.append("\tRetransmitFlag: " + this.getRetransmit() + "\n");
        builder.append("\tSpare: " + this.getSpare() + "\n");
        builder.append("\tDAC: " + this.getDac() + "\n");
        builder.append("\tFI: " + this.getFi() + "\n");
        builder.append("}");
        return builder.toString();
    }

    private void toTable() {
        CommandTable ct = new CommandTable();
        ct.setShowVerticalLines(true);
        ct.setHeaders("Parameter", "Value", "Description");
        ct.addRow("Message ID", String.valueOf(this.getMsgId()), Describer.describeMessageType(this.getMsgId()));
        ct.addRow("Repeater", String.valueOf(this.getRepeater()), Describer.describeRepeater(this.getRepeater()));
        ct.addRow("User ID (MMSI)", String.valueOf(this.getMMSI()), "");
        ct.addRow("Sequence No.", String.valueOf(this.getSequenceNumber()), "");
        ct.addRow("Destination ID (MMSI)", String.valueOf(this.getDestinationMMSI()), "");
        ct.addRow("Re-transmit Flag", String.valueOf(this.getRetransmit()), Describer.describeRetransmit(this.getRetransmit()));
        ct.addRow("Spare", String.valueOf(this.getSpare()), Describer.describeSpare(this.getSpare()));

        ct.print();
    }
}
