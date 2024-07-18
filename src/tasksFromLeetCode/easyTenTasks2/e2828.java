package tasksFromLeetCode.easyTenTasks2;

import java.util.List;

public class e2828 {
    /*2828. Check if a String Is an Acronym of Words*/
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
