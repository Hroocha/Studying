package tasksFromLeetCode.easyTenTasks3;

public class e9 {
    /* 9. Palindrome Number */

    public static void main(String[] args) {
        System.out.println(isPalindrome(23));
    }

    public static boolean isPalindrome(int x) {
        String stringX = Integer.toString(x);
        String stringY = "";
        for (int i = stringX.length() - 1; i != -1; i--) {
            stringY += stringX.charAt(i);
        }
        return stringX.equals(stringY);

//        String stringX = Integer.toString(x);
//        StringBuilder stringY = new StringBuilder(stringX);
//        stringY.reverse();
//        return stringX.contentEquals(stringY);
    }
}
