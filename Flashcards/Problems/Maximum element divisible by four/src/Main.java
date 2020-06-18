import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        int max = 0;
        for (int i = 1; i <= length; i++) {
            String input = scanner.nextLine();
            int nr = Integer.parseInt(input);
            if (nr % 4 == 0 && max < nr) {
                max = nr;
            }
        }
        System.out.println(max);
    }
}
