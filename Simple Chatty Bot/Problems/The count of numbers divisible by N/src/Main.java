import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int n = input.nextInt();
        
        int number = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0) {
                number++;
            }
        }

        System.out.println(number);


    }
}
