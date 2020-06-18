import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        Integer fromInklusive = scanner.nextInt();
        Integer toExklusive = scanner.nextInt();

        int limit = scanner.nextInt();
        scanner.nextLine();

        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < limit; i++) {
            String input = scanner.nextLine();
            String[] str = input.split(" ");

            map.put(Integer.parseInt(str[0]), str[1]);
        }

        Map<Integer, String> subMap = ((TreeMap<Integer, String>) map).subMap(fromInklusive, toExklusive + 1);

        subMap.forEach((key, value) -> System.out.println(key + " " + value));
    }
}