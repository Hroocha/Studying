package tasksFromLeetCode.easyTenTasks4;

public class e796 {
    /* 796. Rotate String */

    public static void main(String[] args) {
        String  s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s,goal));
    }

    public static boolean rotateString(String s, String goal) {
        boolean result = false;
        if (s.length() != goal.length() || goal.length() == 0) {
            return false;
        }
        for (int n = 0; n < goal.length(); n++) {
            int counter = 0;
            int i = 0;
            int y = n;
            while (i < goal.length() && goal.charAt(i++) == s.charAt(y)) {
                y = ++y % goal.length();
                counter++;
            }
            if (counter == goal.length()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static int stepRight(int i, int size) {
        return ++i % size;
    }
}
