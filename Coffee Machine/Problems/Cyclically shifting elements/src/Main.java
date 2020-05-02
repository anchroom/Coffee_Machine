import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String[] elemsinput = scanner.nextLine().split("\\s+");
        int numOfShifts = scanner.nextInt();
        int[] elems = new int[elemsinput.length];

        for (int i = 0; i < elemsinput.length; i++) {
            if (i < elemsinput.length - numOfShifts % elemsinput.length) {
                elems[i + numOfShifts % elemsinput.length] = Integer.parseInt(elemsinput[i]);
            } else {
                elems[(i + numOfShifts) % elemsinput.length] = Integer.parseInt(elemsinput[i]);
            }
        }

        for (int elem: elems) {
            System.out.print(elem + " ");
        }
    }
}