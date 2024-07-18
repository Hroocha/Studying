package tasksFromLeetCode.easyTenTasks5;

import java.util.List;

public class e2855 {
    /* 2855. Minimum Right Shifts to Sort the Array */

    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 4, 5, 1, 2);
        System.out.println(minimumRightShifts(nums));
    }

    public static int minimumRightShifts(List<Integer> nums) {
        int counter = 0;
        int size = nums.size();
        for (int i = 1; i < nums.size(); i++) {

            if (nums.get(i) < nums.get(i - 1) && counter == 0) {
                counter = nums.size() - i;
                if (nums.get(0) < nums.get(nums.size() - 1)) {
                    return -1;
                }
            } else if (nums.get(i) < nums.get(i - 1)) {
                return -1;
            }
        }
        return counter;
    }
}
