package decoder.Binary;

import java.util.Map;

public class Describer {
    public static String describeNavigationStatus(int _i){
        Map<String, String> navigationStatusTable = HashTables.navigationStatusTable();
        return navigationStatusTable.get(Integer.toString(_i));
    }
    public static String describeShip(int _i){
        if(_i >= 100 && _i <= 255){
            return "Reserved, for future use ";
        }
        Map<String, String> formatTable = HashTables.shipTypeTable();
        return formatTable.get(Integer.toString(_i));
    }
    public static String describeFormat(String _value){
        Map<String, String> formatTable = HashTables.formatTable();
        return formatTable.get(_value);
    }
    public static String describeTalker(String _value){
        Map<String, String> talkerTable = HashTables.talkerTable();
        return talkerTable.get(_value);
    }
    public static String describeElectronicPosition(int _i){
        Map<String, String> electronicPositionTable = HashTables.electronicPositionTable();
        return electronicPositionTable.get(Integer.toString(_i));
    }
    public static String describeMessageType(int _i){
        Map<String, String> messageTypeTable = HashTables.messageTypeTable();
        try {
            return messageTypeTable.get(Integer.toString(_i));
        }catch (Exception e){
            return "null";
        }
    }
    public static String describeCallSign(String _binaryString){
        StringBuilder builder = new StringBuilder();
        Map<String, String> binaryToAscii = HashTables.binaryToAscii();
        for(int i = 0; i < 7; i++){
            builder.append(binaryToAscii.get(_binaryString.substring(i*6, (i*6)+6)));
        }
        return builder.toString();
    }
    public static String describeName(String _binaryString){
        StringBuilder builder = new StringBuilder();
        Map<String, String> binaryToAscii = HashTables.binaryToAscii();
        for(int i = 0; i < 20; i++){
            builder.append(binaryToAscii.get(_binaryString.substring(i*6, (i*6)+6)));
        }
        return builder.toString();
    }
    public static String describeDestination(String _binaryString){
        StringBuilder builder = new StringBuilder();
        Map<String, String> binaryToAscii = HashTables.binaryToAscii();
        for(int i = 0; i < 20; i++){
            builder.append(binaryToAscii.get(_binaryString.substring(i*6, (i*6)+6)));
        }
        return builder.toString();
    }
    public static String describeRegionalApplication(int _i){
        return "Not in use";
    }
    public static String describeRaim(int _i){
        if(_i == 0){
            return "Not in use";
        }else{
            return "In use";
        }
    }
    public static String describePosAcc(int _posAcc){
        if(_posAcc == 1){
            return "High (<= 10m)";
        }else{
            return "Low (> 10m) (default)";
        }
    }
    public static String describeSpecialManoeuvre(int _smi){
        if(_smi == 0){
            return "Not Available (Default)";
        } else if (_smi == 1) {
            return "Not Engaged in Special Manoeuvre";
        }else if(_smi == 2){
            return "Engaged in Special Manoeuvre";
        }else{
            return "null";
        }
    }
    public static String describeTimeStamp(int _i){
        return _i + " Seconds Passed the Minute";
    }
    public static String describeSyncState(int _i){
        if(_i == 0){
            return "UTC Direct";
        }else if(_i == 1){
            return "UTC Indirect";
        }else if(_i == 2){
            return "Sync To Base Station";
        }else if(_i == 3){
            return "Sync To Another Station(base on receive)";
        }
        return "Invalid";
    }
    public static String describeAISIndicator(int _i){
        Map<String, String> aisIndicatorTable = HashTables.aisIndicatorTable();
        return aisIndicatorTable.get(Integer.toString(_i));
    }
    public static String describeDTE(int _i){
        return _i == 1 ? "Not Available (Default)" : "Available";
    }
    public static String describeETA(String _etaString){
        StringBuilder builder = new StringBuilder();
        String s = "";
        for(int i = 0; i < _etaString.length(); i++){
            s += _etaString.charAt(i);
            if(i % 2 == 1){
                builder.append(s);
                builder.append("/");
                s = "";
            }
        }
        builder.append("UTC");
        return builder.toString();
    }
    public static String describeAltitudeSensor(int _i){
        if(_i == 0){
            return "GNSS";
        }
        return "Barometric Source";
    }
    public static String describeSpare(int _i){
        if(_i > 0){
            return "In use";
        }
        return "Not in use, Reserved for future use";
    }
    public static String describeCommsSelector(int _i){
        if(_i == 0){
            return "SOTDMA communication state follows";
        }
        return "ITDMA communication state follows";
    }
    public static String describeAssignMode(int _i){
        if(_i == 0){
            return "Station operating in autonomous and continuous mode (Default)";
        }
        return "Station operating in assigned mode";
    }
    public static String describeSlotTimeOut(int _i){
        if(_i == 0){
            return "This is the last transmission in this slot";
        }
        return "";
    }
    public static String describeUnitFlag(int _i){
        return _i == 0 ? "Class B SOTDMA unit" : "Class B CS Unit";
    }
    public static String describeDisplayFlag(int _i){
        return  _i == 0 ? "No display available" : "Equipped with integrated display";
    }
    public static String describeDSCFlag(int _i){
        return _i == 0 ? "Not equipped with DSC function" : "Equipped with DSC function (dedicated or time-shared)";
    }
    public static String describeBandFlag(int _i){
        return _i == 0 ? "Capable of operating over upper 525kHz band of marine band" : "Capable of operating over the whole marine band";
    }
    public static String describeM22Flag(int _i){
        return _i == 0 ? "No frequency management via Message 22, operating on AIS 1, AIS 2 only" : "Frequency management via Message 22";
    }
    public static String describeModeFlag(int _i){
        return _i == 0 ? "Station is operating in autonomous and continuous mode (Default)" : "Station is operating in assigned mode";
    }
    public static String describeNumberOfSlot(int _i){
        return _i + " consecutive slots";
    }
    public static String describeRepeater(int _i){
        return _i == 0 ? "No repeat (Default)" : "";
    }
    public static String describeRetransmit(int _i){
        return _i == 0 ? "No retransmission (Default)" : "";
    }
    public static String describeArrival(char c){
        if(c == 'A'){
            return "Arrival circle entered";
        }
        return "Not passed";
    }
    public static String describePerpendicular(char c){
        if(c == 'A'){
            return "Perpendicular passed at waypoint";
        }
        return "Not passed";
    }
    public static String describeAck(int _i){
        Map<String, String> ackTable = HashTables.ackTable();
        return ackTable.get(String.valueOf(_i));
    }
    public static String describeBandwidth(int _i){
        if(_i == 1){
            return "12.5 kHz";
        }
        return "";
    }
    public static String describeTxRx(int _i){
        if(_i == 0){
            return "Transmit on channels A and B, Receive on channels A and B";
        }
        if(_i == 1){
            return "Transmit on channel A, Receive on channels A and B";
        }
        if(_i == 2){
            return "Transmit on channel B, Receive on channels A and B";
        }
        if(_i == 3){
            return "Do not transmit, Receive on channels A and B";
        }
        if(_i == 4){
            return "Do not transmit, Receive on channel A";
        }
        if(_i == 5){
            return "Do not transmit, Receive on channel B";
        }
        return "";
    }
    public static String describePowerLevel(int _i){
        return _i == 0 ? "High Power" : "Low Power";
    }
    public static String describeIdentificationSource(char _c){
        if(_c == 'A'){
            return "ITU-R M.1371 message 22: Channel Management addressed message";
        }
        if(_c == 'B'){
            return "ITU-R M.1371 message 22: Channel Management broadcast geographical area message";
        }
        if(_c == 'C'){
            return "IEC 61162-1 AIS Channel Assignment sentence";
        }
        if(_c == 'D'){
            return "DSC Channel 70 telecommand";
        }
        if(_c == 'M'){
            return "operator manual input";
        }
        return "";
    }
    public static String describeInUseFlag(int _i){
        return _i == 0 ? "Not in use" : "In use";
    }
    public static String describeAlarmCondition(char _c){
        return _c == 'A' ? "Threshold exceeded" : "Threshold not exceeded";
    }
    public static String describeAlarmAck(char _c){
        return _c == 'A' ? "Acknowledged" : "Unacknowledged";
    }
    public static String describeData(char _c){
        return _c == 'A' ? "Data Valid" : "Loran-C Blink or SNR warning :: general warning flag or other navigation systems when a reliable fix is not available";
    }
    public static String describeCycleLock(char _c){
        return _c == 'A' ? "OK or not used" : "Loran-C Cycle Lock warning flag";
    }
    public static String describeMagnetic(char _c){
        return _c == 'T' ? "True" : "Magnetic";
    }
    public static String describePosMode(char _c){
        if(_c == 'A'){
            return "Autonomous Mode";
        } else if (_c == 'D') {
            return "Differential Mode";
        } else if (_c == 'E') {
            return "Estimated (Dead Reckoning) Mode";
        } else if (_c == 'M') {
            return "Manual Input Mode";
        } else if (_c == 'S') {
            return "Simulator Mode";
        } else if (_c == 'N') {
            return "Data not valid";
        }else{
            return "";
        }
    }
    public static String describeSteer(char _c){
        return _c == 'L' ? "Left" : "Right";
    }
    public static String describeCurrentData(char _c){
        return _c == 'A' ? "Valid" : "Not Valid";
    }
    public static String describeSpeedReference(char _c){
        if(_c == 'B'){
            return "Bottom track";
        } else if (_c == 'W') {
            return "Water track";
        } else if (_c == 'P') {
            return "Position System";
        }else {
            return "Invalid Char";
        }
    }
    public static String describeDirRef(char _c){
        return _c == 'T' ? "True" : "Relative";
    }
    public static String describeFixDataBasis(int _i){
        if(_i == 1){
            return "Normal Pattern";
        } else if (_i == 2) {
            return "Lane Identification Pattern";
        } else if (_i == 3) {
            return "Lane Identification Transmissions";
        }else {
            return "Invalid value";
        }
    }
    public static String describeAck(char _c){
        if(_c == 'R'){
            return "Acknowledge Request";
        } else if (_c == 'B') {
            return "Acknowledgement";
        } else if (_c == 'S') {
            return "Neither Acknowledge Request or Acknowledgement";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeExpansion(char _c){
        if (_c == 'E'){
            return "Expanded, To be followed by DSE";
        }
        return "Invalid Value";
    }
    public static String describeDistress(String _s){
        Map<String, String> distressTable = HashTables.distressTable();
        return distressTable.get(_s);
    }
    public static String describeOpMode(char _c){
        Map<String,String> opModetable = HashTables.opModeTable();
        return opModetable.get(String.valueOf(_c));
    }
    public static String describePower(int _i){
        if(_i == 0){
            return "Standby";
        } else if (_i == 1) {
            return "Lowest";
        }else if(_i == 9){
            return "Highest";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeGPSQuality(char _index){
        Map<String, String> gpsQualityTable = HashTables.gpsQualityTable();
        return gpsQualityTable.get(String.valueOf(_index));
    }
    public static String describeSignalStatus(String _s){
        if(_s.equals("B")){
            return "Blink warning";
        } else if (_s.equals("C")) {
            return "Cycle warning";
        } else if (_s.equals("S")) {
            return "SNR warning";
        } else if (_s.equals("A")) {
            return "Valid";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeMapProjection(String _s){
        if(_s.equals("UTM")){
            return "Universal Transverse Map";
        } else if (_s.equals("LOC")) {
            return "Local Coordinate System";
        }else {
            return "Not available";
        }
    }
    public static String describeMapMode(String _s){
        if(_s.equals("N")){
            return "No fix";
        } else if (_s.equals("A")) {
            return "Autonomous";
        } else if (_s.equals("D")) {
            return "Differential";
        } else if (_s.equals("P")) {
            return "Precise";
        }else if(_s.equals("R")){
            return "Real Time Kinematic";
        } else if (_s.equals("F")) {
            return "Float RTK";
        } else if (_s.equals("E")) {
            return "Estimated";
        } else if (_s.equals("M")) {
            return "Manual Input Mode";
        } else if (_s.equals("S")) {
            return "Simulator Mode";
        }else{
            return "Invalid Data";
        }
    }
    public static String describeSelectionMode(String _s){
        if(_s.equals("M")){
            return "Manual";
        } else if (_s.equals("A")) {
            return "Automatic";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeGSAMode(String _s){
        if(_s.equals("1")){
            return "No Fix";
        } else if (_s.equals("2")) {
            return "2D Fix";
        } else if (_s.equals("3")) {
            return "3D Fix";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeDeviation(String _s){
        if(_s.equals("E")){
            return "Easterly (degrees)";
        } else if (_s.equals("W")) {
            return "Westerly (degrees)";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeHmrWarn(String _s){
        if(_s.equals("A")){
            return "difference within set limit";
        } else if (_s.equals("V")) {
            return "difference exceeds set limit";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeOverride(String _s){
        if(_s.equals("A")){
            return "in use";
        } else if (_s.equals("V")) {
            return "not in use";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeHTCStatus(String _s){
        if(_s.equals("A")){
            return "within limits";
        } else if (_s.equals("V")) {
            return "limit reached or exceeded";
        }else {
            return "Invalid Value";
        }
    }
    public static String describeHTCDir(String _s){
        if(_s.equals("L")){
            return "port";
        } else if (_s.equals("R")) {
            return "stbd";
        }else{
            return "Invalid Value";
        }
    }
    public static String describeHTCSteer(String _s){
        if(_s.equals("M")){
            return "Manual Steering";
        } else if (_s.equals("S")) {
            return "Standalone (heading control)";
        }else if (_s.equals("H")) {
            return "Heading Control";
        }else if (_s.equals("T")) {
            return "Track Control";
        }else if (_s.equals("R")) {
            return "Rudder Control";
        }else{
            return "Invalid Value";
        }
    }
    public static String describeHTCTurnMode(String _s){
        if(_s.equals("R")){
            return "radius controlled";
        } else if (_s.equals("T")) {
            return "turn rate controlled";
        }else if (_s.equals("N")) {
            return "turn is not controlled";
        }else{
            return "Invalid Value";
        }
    }
    public static String describeLR1FunctionRequest(String _s){
        if(_s.equals("A")){
            return "Ship's: name, call sign, and IMO number";
        } else if (_s.equals("B")) {
            return "Date and time of message composition";
        }else if (_s.equals("C")) {
            return "Position";
        }else if (_s.equals("E")) {
            return "Course over ground";
        }else if (_s.equals("F")) {
            return "Speed over ground";
        }if(_s.equals("I")){
            return "Destination and Estimated Time of Arrival";
        } else if (_s.equals("O")) {
            return "Draught";
        }else if (_s.equals("P")) {
            return "Ship / Cargo";
        }else if (_s.equals("U")) {
            return "Ship's: length, breath, type";
        }else if (_s.equals("W")) {
            return "Persons on board";
        }else{
            return "Invalid Value";
        }
    }
}
