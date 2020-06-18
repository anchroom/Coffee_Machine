import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int charAsNum = reader.read();
            char previous = ' ';
            int count = 0;
            while (charAsNum != -1) {
                count += previous == ' ' && charAsNum != ' ' ? 1 : 0;
                previous = (char) charAsNum;
                charAsNum = reader.read();
            }
            System.out.println(count);
        }
    }
}
