import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input.equals(new StringBuilder(input).reverse().toString()) ? "yes" : "no");
    }
}
