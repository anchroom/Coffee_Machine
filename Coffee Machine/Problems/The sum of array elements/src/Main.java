import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner input = new Scanner(System.in);

        int numOfElem = input.nextInt();
        int[] nums = new int[numOfElem];
        int sum = 0;

        for (int i = 0; i < numOfElem; i++) {
            nums[i] = input.nextInt();
            sum += nums[i];
        }
        System.out.println(sum);
    }
}
