import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int numOfStu = scanner.nextInt();
        scanner.nextLine();

        int[] grades = new int[numOfStu];
        int counterOf2 = 0;
        int counterOf3 = 0;
        int counterOf4 = 0;
        int counterOf5 = 0;
        for (int i = 0; i < numOfStu; i++) {
            grades[i] = Integer.parseInt(scanner.nextLine());
            switch (grades[i]) {
                case 2:
                    counterOf2++;
                    break;
                case 3:
                    counterOf3++;
                    break;
                case 4:
                    counterOf4++;
                    break;
                case 5:
                    counterOf5++;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + grades[i]);
            }
        }
        System.out.println(counterOf2 + " " + counterOf3 + " " + counterOf4 + " " + counterOf5);

    }
}
