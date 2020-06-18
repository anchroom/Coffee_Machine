import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        int num = scanner.nextInt();
        int range = scanner.nextInt();
        int seed = low;
        int max = range;

        for (int n = low; n <= high; n++) {
            Random random = new Random(n);
            int midMax = 0;
            for (int i = 0; i < num; i++) {
                int mid = random.nextInt(range);
                if (midMax <= mid) {
                    midMax = mid;
                }
            }
            if (max > midMax) {
                max = midMax;
                seed = n;
            }
        }

        System.out.printf("%d\n%d", seed, max);

    }
}