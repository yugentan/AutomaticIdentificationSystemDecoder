package decoder.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
public class FileReader {
    public static String read(String _filePath) throws Exception{
        String data =  new String(Files.readAllBytes(Paths.get(_filePath)));
        return data;
    }
    public static void write(String _input, String _URI) throws Exception{
        FileWriter myWriter = new FileWriter(_URI);
        myWriter.write(_input);
        myWriter.close();
    }
}
