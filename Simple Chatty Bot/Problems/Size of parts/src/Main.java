import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int numOfShipped = 0;
        int numOfFixed = 0;
        int numOfRejects = 0;

        for (int i = 1; i <= number; i++) {
            int status = input.nextInt();
            switch (status) {
                case 0: 
                    numOfShipped++; 
                    break;
                case 1: 
                    numOfFixed++; 
                    break;
                case -1: 
                    numOfRejects++; 
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        System.out.printf(numOfShipped + " " + numOfFixed + " " + numOfRejects);
    }
}
