package consumer;

public class Deserializer {
    public static String fromHexString(String hex) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
                String str = hex.substring(i, i + 2);
                text.append((char) Integer.parseInt(str, 16));
        }

        return text.toString();
    }
}
