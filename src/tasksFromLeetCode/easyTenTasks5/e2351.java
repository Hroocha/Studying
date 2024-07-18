package tasksFromLeetCode.easyTenTasks5;

import java.util.HashSet;
import java.util.Set;

public class e2351 {
    /* 2351. First Letter to Appear Twice */
    public static void main(String[] args) {
        String s = "abccbaacz";
        System.out.println(repeatedCharacter(s));
    }
    public static char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>(28);
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                return s.charAt(i);
            } else {
                set.add(s.charAt(i));
            }
        }
        return 0;
    }
}
