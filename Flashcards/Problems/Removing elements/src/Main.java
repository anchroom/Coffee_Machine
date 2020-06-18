import java.util.*;

import static java.util.Set.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        String[] num1 = str.split(" ");
        Set<Integer> set = new TreeSet<>();
        for (String elem: num1
             ) {
            set.add(Integer.parseInt(elem));
        }
        return set;


    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
        set.retainAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}