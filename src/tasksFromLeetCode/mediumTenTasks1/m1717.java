package tasksFromLeetCode.mediumTenTasks1;

import java.util.ArrayList;
import java.util.List;

public class m1717 {
    /*1717. Maximum Score From Removing Substrings*/
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        System.out.println(maximumGain(s, x, y));
    }

    public static int maximumGain(String s, int x, int y) {
        int res = 0;
        List<Character> stack = new ArrayList<>();
        String goodVal = x > y ? "ab" : "ba";
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        for (char c : s.toCharArray()) {
            if (c > 'b') {
                res += calculateRemainingStack(stack, min);
                stack.clear();
            } else if (!stack.isEmpty() && c == goodVal.charAt(1) && stack.get(stack.size() - 1) == goodVal.charAt(0)) {
                stack.remove(stack.size() - 1);
                res += max;
            } else {
                stack.add(c);
            }
        }

        if (!stack.isEmpty()) {
            res += calculateRemainingStack(stack, min);
        }
        return res;
    }

    private static int calculateRemainingStack(List<Character> stack, int val) {
        int a = 0, b = 0;
        for (char c : stack) {
            if (c == 'a') {
                a++;
            } else {
                b++;
            }
        }
        return Math.min(a, b) * val;
    }
}
//    public static int maximumGain(String s, int x, int y) {
//        if (s.length() < 2) {
//            return 0;
//        }
//        StringBuilder str = new StringBuilder(s);
//        StringBuilder letters = new StringBuilder("ab");
//        int[] n = new int[1];
//        if (x >= y) {
//            counter(str, letters, x, y, n);
//        } else {
//            counter(str, letters.reverse(), x, y, n);
//        }
//        return n[0];
//    }
//
//    public static int counter(StringBuilder s, StringBuilder l, int x, int y, int[] n) {
//
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == l.charAt(0) && s.charAt(i + 1) == l.charAt(1)) {
//                if(s.charAt(i) == 'a') {
//                    n[0] += x;
//                } else {
//                    n[0] += y;
//                }
//                s.deleteCharAt(i + 1);
//                s.deleteCharAt(i);
//                i--;
//            }
//        }
//
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == l.charAt(1) && s.charAt(i + 1) == l.charAt(0)) {
//                if(s.charAt(i) == 'a') {
//                    n[0] += x;
//                } else {
//                    n[0] += y;
//                }
//                s.deleteCharAt(i + 1);
//                s.deleteCharAt(i);
//                counter(s,l,x,y,n);
//            }
//        }
//
//        return n[0];
//    }

