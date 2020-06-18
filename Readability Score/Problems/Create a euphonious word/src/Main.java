import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] input2 = input.toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        int[] isVowels = new int[input.length()];
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int n = 0; n < 6; n++) {
                if (input2[i] == vowels[n]) {
                    isVowels[i] = 1;
                    break;
                } else {
                    isVowels[i] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (isVowels[i] == isVowels[i + 1]) {
                count++;
                if (count == 2) {
                    result++;
                    count = 0;
                }
            } else count = 0;
        }
        System.out.println(result);
    }
}