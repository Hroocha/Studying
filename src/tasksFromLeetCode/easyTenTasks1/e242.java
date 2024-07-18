package tasksFromLeetCode.easyTenTasks1;

public class e242 {
    /* 242. Valid Anagram */

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] result = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
            result[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) return false;
        }
        return true;
    }
//    public static boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//        char [] sChars = s.toCharArray();
//        char [] tChars = t.toCharArray();
//
//        int counter = 0;
//        for (int i = 0; i < sChars.length; i++) {
//            for (int j = 0; j < tChars.length; j++) {
//                if (sChars[i] == tChars[j]){
//                    counter++;
//                    sChars[i] = tChars[j] = '+';
//                    break;
//                }
//            }
//        }
//        return counter == sChars.length;
//    }
}
