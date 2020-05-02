import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner input = new Scanner(System.in);

        String option = input.next();
        
        switch (option) {
            case "triangle":
                double a = input.nextDouble();
                double b = input.nextDouble();
                double c = input.nextDouble();
                double p = (a + b + c) / 2;
                System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                break;

            case "rectangle":
                double d = input.nextDouble();
                double e = input.nextDouble();
                System.out.println(d * e);
                break;

            case "circle":
                double r = input.nextDouble();
                System.out.println(3.14 * r * r);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
}
