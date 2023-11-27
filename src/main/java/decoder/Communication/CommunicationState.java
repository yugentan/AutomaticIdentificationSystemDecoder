package decoder.Communication;
import decoder.Binary.Binary;
public class CommunicationState {
    public  CommunicationState(){};
    public void parseCommunicationString(String s){
        //SOTDMA
        if(csState){
            this.assignSyncState(s);
            this.assignSlotTimeOut(s);
            this.assignSubMessageCount(s);
        }else{
            this.assignSyncState(s);
            this.assignSlotIncrement(s);
            this.assignNumberOfSlots(s);
            this.assignKeepFlag(s);
        }
        //SyncState
        //ITDMA
    }
    private void assignSyncState(String _s){
        String syncStateString = "";
        try{
            for(int i = 0; i < syncStateCount; i++){
                syncStateString += _s.toCharArray()[i + syncStatePtr];
            }
            setSyncState(Binary.convertToDec(syncStateString));
        }catch (Exception e){
            setSyncState(0);
        }
    }
    private void assignSubMessageCount(String _s){
        String subMessageCountString = "";
        try{
            for(int i = 0; i < subMessageCount; i++){
                subMessageCountString += _s.toCharArray()[i + subMessagePtr];
            }
            setSubMessageInt(Binary.convertToDec(subMessageCountString));
            parseSubMessage(subMessageCountString);
        }catch (Exception e){
            setSubMessageInt(0);
        }
    }
    private void assignSlotTimeOut(String _s){
        String slotTimeOutString = "";
        try{
            for(int i = 0; i < slotTimeoutCount; i++){
                slotTimeOutString += _s.toCharArray()[i + slotTimeoutPtr];
            }
            setSlotTimeOut(Binary.convertToDec(slotTimeOutString));
        }catch (Exception e){
            setSlotTimeOut(0);
        }
    }
    private void assignSlotIncrement(String _s){
        String slotIncrementString = "";
        try {
            for(int i = 0; i < slotIncrementCount; i++){
                slotIncrementString += _s.toCharArray()[i + slotIncrementPtr];
            }
            setSlotIncrement(Binary.convertToDec(slotIncrementString));
        }catch (Exception e){
            setSlotIncrement(0);
        }
    }
    private void assignNumberOfSlots(String _s){
        String numberSlotString = "";
        try {
            for(int i = 0; i < numberOfSlotsCount; i++){
                numberSlotString += _s.toCharArray()[i + numberOfSlotsPtr];
            }
            setNumberOfSlots(Binary.convertToDec(numberSlotString));
        }catch (Exception e){
            setNumberOfSlots(0);
        }
    }
    public void assignKeepFlag(String _s){
        String keepFlagString = "";
        try {
            for (int i = 0; i < keepFlagCount; i++){
                keepFlagString += _s.toCharArray()[i + keepFlagPtr];
            }
            setKeepFlag(Binary.convertToDec(keepFlagString));
        }catch (Exception e){
            setKeepFlag(0);
        }
    }
    /**
     * Getters
     */
    public int getSyncState(){
        return this.syncState;
    }
    public int getSlotTimeOut(){
        return this.slotTimeout;
    }
    public String getSubMessage(){
        return this.subMessage;
    }
    public int getSubMessageInt(){
        return this.subMessageInt;
    }
    public int getCommunicationSlotNumber(){
        return this.communicationSlotNumber;
    }
    public int getReceivedStation(){
        return this.receivedStation;
    }
    public int getCommunicationSlotOffset(){
        return this.communicationSlotOffset;
    }
    public Boolean getCsState(){
        return this.csState;
    }

    public int getSlotIncrement(){
        return this.slotincrement;
    }

    public int getNumberOfSlots(){
        return this.numberOfSlots;
    }

    public int getKeepFlag(){
        return this.keepFlag;
    }
    /**
     * Setters
     */
    public void setSyncState(int _i){
        this.syncState = _i;
    }
    public void setCsState(Boolean _b){
        this.csState = _b;
    }
    public void setSlotTimeOut(int i){
        this.slotTimeout = i;
    }
    public void setSubMessage(String s){
        this.subMessage = s;
    }
    public void setSubMessageInt(int i){
        this.subMessageInt = i;
    }
    public void setCommunicationSlotNumber(int _i){
        this.communicationSlotNumber = _i;
    }
    public void setReceivedStation(int _i){
        this.receivedStation = _i;
    }
    public void setCommunicationSlotOffset(int _i){
        this.communicationSlotOffset = _i;
    }

    public void setSlotIncrement(int i){
        this.slotincrement = i;
    }

    public void setNumberOfSlots(int i){
        this.numberOfSlots = i;
    }

    public void setKeepFlag(int i){
        this.keepFlag = i;
    }

    private void parseSubMessage(String s){
        if(csState){
            int tout = this.getSlotTimeOut();
            String rData = "";
            if(tout == 3 || tout == 5 || tout == 7){
                System.out.println("Receive Station");
            }else if(tout == 2 || tout == 4 || tout == 6){
                System.out.println("Slot number");
            }else if(tout == 0){
                setSubMessage(String.valueOf(getSubMessageInt()));
            }else if(tout == 1){
                int hrPtr = 0, hrCount = 5;
                int minPtr = 5, minCount = 7;
                String hr = "", min = "";
                for(int i = 0; i < hrCount; i++){
                    rData += s.toCharArray()[i + hrPtr];
                }
                if(Binary.convertToDec(rData) < 10){
                    hr = "0"+Binary.convertToDec(rData);
                }else{
                    hr = String.valueOf(Binary.convertToDec(rData));
                }
                rData = "";
                for(int i = 0; i < minCount; i++){
                    rData += s.toCharArray()[i + minPtr];
                }
                if(Binary.convertToDec(rData) < 10){
                    min = "0"+ Binary.convertToDec(rData);
                }else{
                    min = String.valueOf(Binary.convertToDec(rData));
                }
                rData = "";
                setSubMessage(hr + ":" + min + " UTC");
            }
        }else{
            setSubMessage("");
        }

    }

    private String data = "";

    private int syncState;
    private int slotTimeout;
    private String subMessage;
    private int subMessageInt;
    private int communicationSlotNumber;
    private int receivedStation;
    private int communicationSlotOffset;
    private Boolean csState;
    private int slotincrement;
    private int numberOfSlots;
    private int keepFlag;
    private int syncStatePtr = 0, syncStateCount = 2;
    private int slotTimeoutPtr = 2, slotTimeoutCount = 3;
    private int subMessagePtr = 5, subMessageCount = 14;
    private int slotIncrementPtr = 2, slotIncrementCount = 13;
    private int numberOfSlotsPtr = 15, numberOfSlotsCount = 3;
    private int keepFlagPtr = 18, keepFlagCount = 1;
}
