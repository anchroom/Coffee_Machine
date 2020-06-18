import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadingFileDemo {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllLines(Paths.get(fileName)).toString());
    }

    public static void main(String[] args) {
        String pathToHelloWorldJava = "/Users/anchroom/Downloads/dataset_91065.txt";
        try {
            count(readFileAsString(pathToHelloWorldJava));
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
    }

    private static void count(String str) {
        int count = 0;
        String[] strings = str.substring(1, str.length()-1).split(", ").clone();
        for (String num: strings
             ) {
            System.out.println(num);
            if (Integer.parseInt(num) != 0 && Integer.parseInt(num) % 2 == 0) {
                count++;
            } else if (Integer.parseInt(num) == 0) {
                break;
            }

        }
        System.out.println(count);
    }
}
