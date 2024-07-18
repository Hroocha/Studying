package tasksFromLeetCode.easyTenTasks1;

public class e35 {
    /* 35. Search Insert Position */

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target <= nums[0]) {
            return 0;
        }
        return finder(nums, target, 0, nums.length - 1);
    }

    public static int finder(int[] nums, int target, int from, int to) {
        if (from == to) {
            if (nums[from] < target) {
                return from + 1;
            } else {
                return from;
            }
        }
        if (from + 1 == to) {
            return to;
        }

        int mid = (from + to) / 2;

        if (target > nums[mid]) {
            return finder(nums, target, mid, to);
        } else if (nums[mid] > target) {
            return finder(nums, target, from, mid);
        }
        return mid;
    }

}
