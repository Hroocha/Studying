package tasksFromLeetCode.mediumTenTasks1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class m1657 {
    /* 1657. Determine if Two Strings Are Close */
    public static void main(String[] args) {
        String word1 = "abbzzca";
        String word2 = "babzzcz";
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() == word2.length()) {
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < word1.length(); i++) {
                map1.merge(word1.charAt(i), 1, Integer::sum);
                map2.merge(word2.charAt(i), 1, Integer::sum);
            }
            if (map1.keySet().size() == map2.keySet().size()) {
                Integer[] array1 = map1.values().toArray(new Integer[0]);
                Integer[] array2 = map2.values().toArray(new Integer[0]);
                Arrays.sort(array1);
                Arrays.sort(array2);
                if (Arrays.equals(array1, array2)) {
                    for (Character c : map1.keySet()) {
                        if (!map2.containsKey(c)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
