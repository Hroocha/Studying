package tasksFromLeetCode.easyTenTasks4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class e389 {
    /* 389. Find the Difference */

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }

    public static char findTheDifference(String s, String t) {
        Map<Character,Integer> mapS = new HashMap<>();
        Map<Character,Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.merge(s.charAt(i), 1, Integer::sum );
            mapT.merge(t.charAt(i), 1, Integer::sum );
        }
        mapT.merge(t.charAt(t.length() - 1), 1, Integer::sum);
        Character [] keySet = mapT.keySet().toArray(new Character[0]);
        for (Character character : keySet) {
            if (!mapS.containsKey(character)) {
                return character;
            } else if (!Objects.equals(mapS.get(character), mapT.get(character))) {
                return character;
            }
        }
        return 0;
    }
}
