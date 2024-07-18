package tasksFromLeetCode.easyTenTasks2;

import java.util.ArrayList;
import java.util.List;

public class e2942 {
    /*2942. Find Words Containing Character*/

    public static void main(String[] args) {
        String [] words = {"leet","code"};
        char x = 'e';
        System.out.println(findWordsContaining(words,x));
    }
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}
