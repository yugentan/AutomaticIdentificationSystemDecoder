package decoder.Binary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Binary {
    public static int convertToDec(String bin)
    {
        int[] binArray = new int[1024];
        int eqv_dec = 0;

        // Converting characters of Binary String to
        // primitive integer and storing it in the Array in
        // reverse order!!
        for (int i = bin.length() - 1; i >= 0; i--) {
            binArray[i]
                    = Character.getNumericValue(bin.charAt(i));
        }

        // Evaluating Equivalent Decimal Number from the
        // Binary Array!!
        for (int i = 0; i < bin.length(); i++) {
            if (binArray[i] == 1) {
                eqv_dec += (int)Math.pow(2, bin.length() - 1 - i);
            }
            else
                continue;
        }
        return eqv_dec;
    }

    public static char flip(char c)
    {
        return (c == '0') ? '1' : '0';
    }

    // Print 1's and 2's complement of binary number
    // represented by "bin"
    public static String printOneAndTwosComplement(String bin)
    {
        int n = bin.length();
        int i;

        StringBuilder ones = new StringBuilder();
        String twos = "";
        ones = new StringBuilder(twos = "");

        // for ones complement flip every bit
        for (i = 0; i < n; i++)
        {
            ones.append(flip(bin.charAt(i)));
        }

        // for two's complement go from right to left in
        // ones complement and if we get 1 make, we make
        // them 0 and keep going left when we get first
        // 0, make that 1 and go out of loop
        twos = ones.toString();
        for (i = n - 1; i >= 0; i--)
        {
            if (ones.charAt(i) == '1')
            {
                twos = twos.substring(0, i) + '0' + twos.substring(i + 1);
            }
            else
            {
                twos = twos.substring(0, i) + '1' + twos.substring(i + 1);
                break;
            }
        }

        // If No break : all are 1 as in 111 or 11111;
        // in such case, add extra 1 at beginning
        if (i == -1)
        {
            twos = '1' + twos;
        }

        if(bin.toCharArray()[0] == '1'){
            return twos;
        }else{
            return bin;
        }
    }
    /** POSITIONAL*/
    /**
     * Calc rate of turn Still need adj
     * ROTAIS = 4.733 SQRT(ROTsensor) degrees per min */
    public static Float getSensorRot(int _rot) {
        if (_rot == 128) {
            return null;
        }
        int signedRot = (byte)_rot;
        float sensorRot = (float)Math.pow(signedRot / 4.733, 2);
        if (signedRot < 0) {
            sensorRot *= -1;
        }
        return sensorRot;
    }

    public static Float getSOG(int _i){
        return (float) _i / 10;
    }
    public static Float getCOG(int _i){
        return (float) _i / 10;
    }
    public static Float getDraught(int _i){return (float) _i / 10;}
    public static String decToLong(int dec, char c){
        StringBuilder builder = new StringBuilder();
        Double sensorLon = (double)(dec / 10000f / 60f);
        if(sensorLon == 181 ){
            builder.append("Not available");
            return builder.toString();
        }
        if(c == '0'){
            builder.append(sensorLon).append(" East");
        }else{
            builder.append(sensorLon).append(" West");
        }
        return builder.toString();
    }
    public static String decToLat(int lat, char c){
        StringBuilder builder = new StringBuilder();
        Double sensorLat = (double)(lat / 10000f / 60f);
        if(sensorLat == 91 ){
            builder.append("Not available");
            return builder.toString();
        }
        if(c == '0'){
            builder.append(sensorLat).append(" North");
        }else{
            builder.append(sensorLat).append(" South");
        }
        return builder.toString();
    }
    /** POSITIONAL*/

    public static String evaluateDimension(String _binaryString){
        StringBuilder builder = new StringBuilder();
        final int aPtr = 0, aCount = 9;
        final int bPtr = 9, bCount = 9;
        final int cPtr = 18, cCount = 6;
        final int dPtr = 24, dCount = 6;
        String workingString = "";
        for(int i = 0; i < aCount; i++){
            workingString += _binaryString.charAt(i + aPtr);
        }
        builder.append("A = " + convertToDec(workingString));
        workingString = "";

        for(int i = 0; i < bCount; i++){
            workingString += _binaryString.charAt(i + bPtr);
        }
        builder.append(" B = " + convertToDec(workingString));
        workingString = "";

        for(int i = 0; i < cCount; i++){
            workingString += _binaryString.charAt(i + cPtr);
        }
        builder.append(" C = " + convertToDec(workingString));
        workingString = "";

        for(int i = 0; i < dCount; i++){
            workingString += _binaryString.charAt(i + dPtr);
        }
        builder.append(" D = " + convertToDec(workingString));

        return builder.toString();
    }
    public static String addZero(int _i){

        return _i < 10 ? "0" + _i : Integer.toString(_i);
    }
    public static String binaryToUTCETA(String _binaryString){
        StringBuilder builder = new StringBuilder();
        int mthPtr = 0, mthCount = 4;
        int dayPtr = 4, datCount = 5;
        int hrPtr = 9, hrCount = 5;
        int minPtr = 14, minCount =6;
        String workingString = "";
        for(int i = 0; i < mthCount; i++){
            workingString += _binaryString.toCharArray()[i + mthPtr];
        }
        builder.append(addZero(Binary.convertToDec(workingString)));
        workingString = "";
        for(int i = 0; i < datCount; i++){
            workingString += _binaryString.toCharArray()[i + dayPtr];
        }
        builder.append(addZero(Binary.convertToDec(workingString)));
        workingString = "";
        for(int i = 0; i < hrCount; i++){
            workingString += _binaryString.toCharArray()[i + hrPtr];
        }
        builder.append(addZero(Binary.convertToDec(workingString)));
        workingString = "";
        for (int i = 0; i < minCount; i++){
            workingString += _binaryString.toCharArray()[i + minPtr];
        }
        builder.append(addZero(Binary.convertToDec(workingString)));
        return builder.toString();
    }
     /** Time constraint checker START*/
     private static final String TIME_PATTERN = "^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)\\.\\d{2}$";
     private static final Pattern pattern = Pattern.compile(TIME_PATTERN);
     public static boolean isValidTime(final String time) {
         Matcher matcher = pattern.matcher(time);
         return matcher.matches();
     }
}

