import java.util.Enumeration;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int i = 1;
        int min = 1;

        while (i <= sum) {
            System.out.println(decompositions(i, min, sum));

            i++;
        }
    }

    private static String decompositions(int i, int second, int sum) {
        int j = 1;

        if (sum == 0) {
            return "\n";
        } else if (i <= sum) {
            return i + decompositions(i, sum - i);
        } else {
            return decompositions(i - 1, sum);
        }
    }
}