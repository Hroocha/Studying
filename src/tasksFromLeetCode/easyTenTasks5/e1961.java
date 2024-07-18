package tasksFromLeetCode.easyTenTasks5;

public class e1961 {
    /* 1961. Check If String Is a Prefix of Array */

    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] words = {"i", "love", "leetcode", "apples"};
        System.out.println(isPrefixString(s,words));
    }

    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        while (str.length() < s.length() && index < words.length) {
            str.append(words[index++]);
        }
        if (str.length() == s.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != str.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
