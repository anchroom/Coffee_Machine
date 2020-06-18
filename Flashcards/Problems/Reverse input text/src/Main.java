import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // start coding here
            int charAsNum = reader.read();
            String output = "";
            while (charAsNum != -1) {
                char input = (char) charAsNum;
                output = "" + input + output;
                charAsNum = reader.read();
            }
            System.out.println(output);
        }
    }
}
