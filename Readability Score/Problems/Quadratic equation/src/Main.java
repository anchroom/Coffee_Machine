import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double result1 = (b * (-1) - Math.sqrt(Math.pow(b, 2) - 4.0 * a * c)) / (2 * a);
        double result2 = (b * (-1) + Math.sqrt(Math.pow(b, 2) - 4.0 * a * c)) / (2 * a);
        System.out.println(a > 0 ? result1 + " " + result2 : result2 + " " + result1);
    }
}