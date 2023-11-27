package decoder.Binary;

import decoder.FileReader.FileReader;
import org.apache.logging.log4j.*;

import java.util.HashMap;
import java.util.Map;
public class HashTables {
    public static Map<String, String> binaryToStringTable(){
        Map<String, String> bitsToString = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/6bitspayload.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",");
                bitsToString.put(dataArray[1], dataArray[0]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: 6bitspayload");
        }
        return bitsToString;
    }
    public static Map<String, String> StringTobinaryTable(){
        Map<String, String> StringTobinary = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/6bitspayload.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",");
                StringTobinary.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: 6bitspayload");
        }
        return StringTobinary;
    }
    public static Map<String, String> binaryToAscii(){
        Map<String, String> binaryToAscii = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/6bitsASCII.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",");
                binaryToAscii.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: 6BitsASCII");
        }
        return binaryToAscii;
    }
    public static Map<String, String> AsciiTobinary(){
        Map<String, String> AsciiTobinary = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/6bitsASCII.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",");
                AsciiTobinary.put(dataArray[1], dataArray[0]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: 6BitsASCII");
        }
        return AsciiTobinary;
    }
    public static Map<String, String> formatTable(){
        Map<String, String> formatTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/format.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",");
                formatTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: format");
        }
        return formatTable;
    }
    public static Map<String, String> talkerTable(){
        Map<String, String> talkerTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/talker.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",");
                talkerTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: talker");
        }
        return talkerTable;
    }
    public static Map<String, String> shipTypeTable(){
        Map<String, String> shipTypeTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/shipCargoClassification.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                shipTypeTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: shipCargoClassification");
        }
        return shipTypeTable;
    }
    public static Map<String, String> navigationStatusTable(){
        Map<String, String> navigationStatusTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/navigationStatus.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                navigationStatusTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: navigationStatus");
        }
        return navigationStatusTable;
    }
    public static Map<String, String> electronicPositionTable(){
        Map<String, String> electronicPositionTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/electronicPosition.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                electronicPositionTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: electronicPosition");
        }
        return electronicPositionTable;
    }
    public static Map<String, String> messageTypeTable(){
        Map<String, String> messageTypeTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/messageType.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                messageTypeTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: messageType");
        }
        return messageTypeTable;
    }
    public static Map<String, String> aisIndicatorTable(){
        Map<String, String> aisIndicatorTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/aisIndicator.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                aisIndicatorTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: messageType");
        }
        return aisIndicatorTable;
    }
    public static Map<String, String> DACTable(){
        Map<String, String> dacTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/DAC.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                dacTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: dacTable");
        }
        return dacTable;
    }
    public static Map<String, String> FITable(){
        Map<String, String> fiTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/FI.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                fiTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: fiTable");
        }
        return fiTable;
    }
    public static Map<String, String> ackTable(){
        Map<String, String> ackTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/ack.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                ackTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: ack.csv");
        }
        return ackTable;
    }
    public static Map<String, String> distressTable(){
        Map<String, String> distressTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/distress.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                distressTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: distress.csv");
        }
        return distressTable;
    }
    public static Map<String, String> opModeTable(){
        Map<String, String> opModeTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/modeOfOperation.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                opModeTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: modeOfOperation.csv");
        }
        return opModeTable;
    }
    public static Map<String, String> gpsQualityTable(){
        Map<String, String> gpsQualityTable = new HashMap<>();
        String data= "";
        try{
            data = FileReader.read("data/gpsQuality.csv");
            String[] splitString = data.split(System.lineSeparator());
            for(String i: splitString) {
                String[] dataArray = i.split(",", 2);
                gpsQualityTable.put(dataArray[0], dataArray[1]);
            }
        }catch(Exception e){
            logger.error("File error, fail to read file");
            System.out.println("Hashmap Err: gpsQuality.csv");
        }
        return gpsQualityTable;
    }
    private static Logger logger = LogManager.getLogger(HashTables.class.getName());

}
