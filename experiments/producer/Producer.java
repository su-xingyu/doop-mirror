import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Producer {
	public static void main(String[] args) throws IOException {
                String fileName1 = "fun1.txt";
                String fun1Text = fun1();
                System.out.println("fun1 encoded : " + fun1Text);
                toFile(fileName1, fun1Text);

                String fileName2 = "fun2.txt";
                String fun2Text = fun2();
                System.out.println("fun2 encoded : " + fun2Text);
                toFile(fileName2, fun2Text);
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

        private static String fun1() {
                String text = "abcdefg";
                String hex = toHexString(text);
                String idHex = id(hex);
                return idHex;
        }

        private static String fun2() {
                String text = "hijklmn";
                String hex = toHexString(text);
                String idHex = id(hex);
                return idHex;
        }

        private static String id(String str) {
                return str;
        }
}

