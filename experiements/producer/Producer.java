import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Producer {
	public static void main(String[] args) throws IOException {
                String fileName = "temp.txt";
                String text = "Hello World!";
                String hex = toHexString(text);
                System.out.println("Encoded: " + hex);
                toFile(fileName, hex);
	}

        private static String toHexString(String text) {
                byte[] bytes = text.getBytes();
                StringBuilder hexString = new StringBuilder();

                for (byte b : bytes) {
                        String hex = Integer.toHexString(0xFF & b);
                        if (hex.length() == 1) {
                                hexString.append('0');
                        }
                        hexString.append(hex);
                }

                return hexString.toString();
        }

        private static void toFile(String fileName, String text) throws IOException {
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(text);
                fileWriter.close();
        }
}

