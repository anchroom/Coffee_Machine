class Problem {

    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[1]);
        int num2 = Integer.parseInt(args[2]);

        if (args[0].equals("+")) {
            System.out.println(num1 + num2);
        } else if (args[0].equals("-")) {
            System.out.println(num1 - num2);
        } else if (args[0].equals("*")) {
            System.out.println(num1 * num2);
        } else {
            System.out.println("Unknown operator");
        }
    }
}
