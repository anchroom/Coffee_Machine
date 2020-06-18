/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int[] nums = new int[args.length - 1];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            nums[i - 1] = Integer.parseInt(args[i]);
            if (max < nums[i - 1]) {
                max = nums[i - 1];
            }

            if (min > nums[i - 1]) {
                min = nums[i - 1];
            }

            sum += nums[i - 1];
        }
        // write your code here
        switch (operator) {
            case "MAX":
                System.out.println(max);
                break;

            case "MIN":
                System.out.println(min);
                break;

            case "SUM":
                System.out.println(sum);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }
}