import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nr1 = scanner.nextInt();
        int nr2 = scanner.nextInt();
        int nr3 = scanner.nextInt();
        
        System.out.println(nr1 >= nr2 && nr1 <= nr3 || nr1 <= nr2 && nr1 >= nr3);
    }
}
