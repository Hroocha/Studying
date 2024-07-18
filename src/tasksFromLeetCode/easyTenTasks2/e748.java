package tasksFromLeetCode.easyTenTasks2;

import java.util.ArrayList;
import java.util.List;

public class e748 {
    /*748. Shortest Completing Word*/

    public static void main(String[] args) {
        String[] words = new String[]{"step", "steps", "stripe", "stepple"};
        String licensePlate = "s3 PSt";
        System.out.println(shortestCompletingWord(licensePlate,words));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        char[] arr = licensePlate.toLowerCase().toCharArray();
        List<Character> cur = new ArrayList<>();

        for (char c : arr) {
            if (!Character.isDigit(c) && c != ' ') {
                cur.add(c);
            }
        }

        int maxMatches = 0;
        int index = 0;

        for (int i = 0; i < words.length; i++) {
            char[] wordChar = words[i].toLowerCase().toCharArray();
            List<Character> copyOfCur = new ArrayList<>(cur);

            int curMatch = 0;

            for (char c : wordChar) {
                for (int j = 0; j < copyOfCur.size(); j++) {
                    if (c == copyOfCur.get(j)) {
                        curMatch++;
                        copyOfCur.set(j, '+');
                        break;
                    }
                    if (copyOfCur.get(j) == '\u0000') {
                        break;
                    }
                }
            }

            if (curMatch > maxMatches) {
                maxMatches = curMatch;
                index = i;

            } else if (curMatch == maxMatches && words[i].length() < words[index].length()) {
                index = i;
            }
        }

        return words[index];
    }
}
