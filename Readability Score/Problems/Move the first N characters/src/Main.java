import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int num = scanner.nextInt();

        if (num >= input.length()) {
            System.out.println(input);
        } else {
            String sub1 = input.substring(0, num);
            String sub2 = input.substring(num, input.length());
            System.out.println(sub2 + sub1);
        }

    }
}