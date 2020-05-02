import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        int root = 1;
        while (root <= Math.sqrt(num)) {
            System.out.println(root * root);
            root++;
        }
    }
}