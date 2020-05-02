import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner input = new Scanner(System.in);

        String str1 = input.nextLine();
        String str2 = input.nextLine();

        System.out.println(str1.replaceAll(" ", "").equals(str2.replaceAll(" ", "")));
    }
}