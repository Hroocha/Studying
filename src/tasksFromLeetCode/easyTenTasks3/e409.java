package tasksFromLeetCode.easyTenTasks3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class e409 {
    /* 409. Longest Palindrome*/

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        int answer = 0;
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        answer = map.values().stream().filter(n -> n % 2 == 0).mapToInt(Integer::valueOf).sum();
        int[] nums = map.values().stream().filter(m -> m % 2 == 1).mapToInt(Integer::valueOf).toArray();
        int countN = Arrays.stream(nums).sum();
        if (countN != 0) {
            int count = (int) Arrays.stream(nums).count();
            answer = answer + countN - count + 1;
        }
        return answer;
    }
}
