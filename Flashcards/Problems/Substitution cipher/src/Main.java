import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String ori = scanner.nextLine();
        String code = scanner.nextLine();
        String toCode = scanner.nextLine();
        String toOri = scanner.nextLine();

        char[] oriInArr = ori.toCharArray();
        char[] codeInArr = code.toCharArray();
        char[] toCodeInArr = toCode.toCharArray();
        char[] toOriInArr = toOri.toCharArray();

        Map<Character, Character> encodeMap = new LinkedHashMap<>();
        Map<Character, Character> decodeMap = new LinkedHashMap<>();

        for (int i = 0; i < ori.length(); i++) {
            encodeMap.put(oriInArr[i], codeInArr[i]);
            decodeMap.put(codeInArr[i], oriInArr[i]);
        }

        System.out.println(encode(toCodeInArr, encodeMap));
        System.out.println(decode(toOriInArr, decodeMap));

    }

    private static String encode(char[] toCodeInArray, Map<Character, Character> encodeMap) {
        String result = "";

        for (int i = 0; i < toCodeInArray.length; i++) {
            result = result + encodeMap.get(toCodeInArray[i]);
        }
        return  result;
    }

    private static String decode(char[] toOriInArray, Map<Character, Character> decodeMap) {
        String result = "";

        for (int i = 0; i < toOriInArray.length; i++) {
            result = result + decodeMap.get(toOriInArray[i]);
        }
        return  result;
    }
}