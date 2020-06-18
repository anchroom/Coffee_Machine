import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String[] listArray = scanner.nextLine().split("\\s+");
        int numN = Integer.parseInt(scanner.nextLine());


        ArrayList<Integer> list = new ArrayList<>();
        int distance = Integer.MAX_VALUE;

        // find min distance
        for (String s : listArray) {
            int num = Integer.parseInt(s);
            list.add(num);
            if (distance > Math.abs(num - numN)) {
                distance = Math.abs(num - numN);
            }
        }

        int finalDistance = distance;
        list.removeIf(elem -> Math.abs(elem - numN) != finalDistance);
        Collections.sort(list);
        list.forEach(elem -> System.out.print(elem + " "));


    }
}
