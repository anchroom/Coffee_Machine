import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        int charAsNum = inputStream.read();
        while (charAsNum != -1) {
            int character = (int) charAsNum;
            System.out.print(character);
            charAsNum = inputStream.read();
        }
        inputStream.close();

    }
}
