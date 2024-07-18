package tasksFromLeetCode.easyTenTasks3;

import java.util.Arrays;

public class e628 {
    /* 628. Maximum Product of Three Numbers */

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(maximumProductP(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int product2 = nums[n - 1] * nums[0] * nums[1];
        return Math.max(product1, product2);
    }
    public static int maximumProductP(int[] nums) {
        Arrays.sort(nums);
        int one = Math.abs(nums[0]);
        int two = Math.abs(nums[1]);
        if (one > nums[nums.length - 2] && two > nums[nums.length - 3]) {
            return nums[nums.length - 1] * one * two;
        } else {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }
    }
}
