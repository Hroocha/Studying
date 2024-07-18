package tasksFromLeetCode.easyTenTasks3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class e594 {
    /* 594. Longest Harmonious Subsequence */
    public static void main(String[] args) {
        int [] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
    public static int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> isOnlyOneNumber = new HashSet<>();
        Set<Integer> setOfLength = new HashSet<>();
        for (int num : nums) {
            isOnlyOneNumber.add(num);
            int arrOtIPlusOne = 0;
            int arrOtIMinusOne = 0;
            int itSelf = 0;
            for (int i : nums) {
                if (num == i + 1) {
                    arrOtIPlusOne++;
                } else if (num == i - 1) {
                    arrOtIMinusOne++;
                } else if (num == i) {
                    itSelf++;
                }
            }
            if (arrOtIMinusOne == 0 && arrOtIPlusOne == 0) {
                setOfLength.add(0);
            } else {
                setOfLength.add(arrOtIPlusOne + itSelf);
                setOfLength.add(arrOtIMinusOne + itSelf);
            }
        }
        if (isOnlyOneNumber.size() == 1 || (isOnlyOneNumber.size() == nums.length && !setOfLength.contains(2))) {
            return 0;
        }
        List<Integer> arrayList = setOfLength.stream().sorted().toList();
        return arrayList.get(arrayList.size() - 1);
    }


}
