import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Random random = new Random(a + b);
        int i = 0; // count the times
        int sum = 0;

        while (i < n) {
            sum += random.nextInt(b - a + 1) + a;
            i++;
        }

        System.out.println(sum);
    }
}