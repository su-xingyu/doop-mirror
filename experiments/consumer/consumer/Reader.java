package consumer;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Reader {
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public String fromFile() throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(line);
        }

        bufferedReader.close();
        fileReader.close();

        return stringBuilder.toString();
    }
}
