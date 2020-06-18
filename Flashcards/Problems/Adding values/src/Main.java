import java.util.*;

public class Main {

    // write a method here
    private static void addValueByIndex(int index, long value, long[] array) {
        array[index] += value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        int index = scanner.nextInt();
        long value = scanner.nextLong();
        addValueByIndex(index, value, array);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}