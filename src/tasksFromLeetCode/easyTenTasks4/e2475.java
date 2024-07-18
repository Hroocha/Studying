package tasksFromLeetCode.easyTenTasks4;

import java.util.Arrays;

public class e2475 {
    /*2475. Number of Unequal Triplets in Array*/

    public static void main(String[] args) {
        int [] nums = {4,4,2,4,3};
        System.out.println(unequalTriplets(nums));
    }

    public static int unequalTriplets(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] < nums[k]) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
