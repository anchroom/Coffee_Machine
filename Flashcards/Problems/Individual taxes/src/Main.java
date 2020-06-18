import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int numOfCompany = sc.nextInt();
        sc.nextLine();
        String[] inputIncomes = sc.nextLine().split(" ");
        String[] inputTax = sc.nextLine().split(" ");
        int[] incomes = new int[numOfCompany];
        int[] taxRate = new int[numOfCompany];
        int[] taxs = new int[numOfCompany];
        int maxNum = 1;
        int maxTax = 0;
        for (int i = 0; i < numOfCompany; i++) {
            incomes[i] = Integer.parseInt(inputIncomes[i]);
            taxRate[i] = Integer.parseInt(inputTax[i]);
            taxs[i] = incomes[i] * taxRate[i];
            maxTax = maxTax <= taxs[i] ? taxs[i] : maxTax;
            maxNum = maxTax <= taxs[i] ? i + 1 : maxNum;
        }
        System.out.println(maxNum);
    }
}