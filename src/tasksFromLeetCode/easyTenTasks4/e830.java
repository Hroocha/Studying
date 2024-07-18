package tasksFromLeetCode.easyTenTasks4;

import java.util.ArrayList;
import java.util.List;

public class e830 {
    /* 830. Positions of Large Groups */

    public static void main(String[] args) {
        String s = "abbxxxxzzy";
        System.out.println(largeGroupPositions(s));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        if (s.length() < 3) {
            return list;
        }
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> subList = new ArrayList<Integer>(2);
                    subList.add(i - count);
                    subList.add(i - 1);
                    list.add(subList);
                }
                count = 1;
            }
            if (i == s.length() - 1 && count >= 3) {
                List<Integer> subList = new ArrayList<Integer>(2);
                subList.add(i - count + 1);
                subList.add(i);
                list.add(subList);
            }
        }
        return list;
    }

}
