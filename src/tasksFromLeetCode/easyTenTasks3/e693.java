package tasksFromLeetCode.easyTenTasks3;

public class e693 {
    /* 693. Binary Number with Alternating Bits*/

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
    }

    public static boolean hasAlternatingBits(int n) {
        boolean result = true;
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
