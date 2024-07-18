package tasksFromLeetCode.easyTenTasks1;

import java.util.ArrayList;
import java.util.List;

public class e228 {
    /* 228. Summary Ranges */

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int start = nums[0];
        int end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                end = nums[i - 1];
                if (start == end) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + end);
                }
                start = nums[i];
                if (i + 1 == nums.length) {
                    end = nums[i];
                    list.add(String.valueOf(start));
                }
            } else if (i == nums.length - 1) {
                end = nums[i];
                list.add(start + "->" + end);
            }
        }
        return list;
    }

}
