import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String originalInput = scanner.nextLine();
        String[] message = originalInput.split(" ");
        boolean result = true;
        for (int i = 0; i < message.length - 1; i++) {
            result = result && (message[i].compareTo(message[i + 1]) <= 0 ? true : false);
        }
        System.out.println(result);
    }
}
