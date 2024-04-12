import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Consumer {
	public static void main(String[] args) throws IOException {
                String fileName = "temp.txt";
                String fileHex = fromFile(fileName);
                String fileText = fromHexString(fileHex);
                System.out.println("Decoded: " + fileText);
	}

        private static String fromHexString(String hex) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < hex.length(); i += 2) {
                        String str = hex.substring(i, i + 2);
                        text.append((char) Integer.parseInt(str, 16));
                }

                return text.toString();
        }

        private static String fromFile(String fileName) throws IOException {
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

