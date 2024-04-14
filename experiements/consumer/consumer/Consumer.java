package consumer;
import java.io.IOException;

public class Consumer {
	public static void main(String[] args) throws IOException {
                Reader reader = new Reader("fun1.txt");
                String fileHex = reader.fromFile();
                String fileText = Deserializer.fromHexString(fileHex);
                System.out.println("Decoded: " + fileText);
	}
}

