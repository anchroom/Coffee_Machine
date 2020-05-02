import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int sum = 0;

        while (number != 0) {
            sum += number;
            number = input.nextInt();
        }
        System.out.println(sum);
    }
}