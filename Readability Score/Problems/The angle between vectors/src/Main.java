import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();

        System.out.println(Math.toDegrees(Math.acos((a1 * b1 + a2 + b2) / (Math.hypot(a1, b1) * Math.hypot(a2, b2)))));
    }
}