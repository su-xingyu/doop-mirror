import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Exp {
	public static void main(String[] args) throws IOException {
                String fileName = "temp.txt";
                String content = "Hello World!";
                writeFile(fileName, content);
                String fileContent = readFile(fileName);
                assert fileContent.equals(content);
                System.out.println(fileContent);
	}


        private static void writeFile(String fileName, String content) throws IOException {
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(content);
                fileWriter.close();
        }

        private static String readFile(String fileName) throws IOException {
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

