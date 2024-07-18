package tasksFromLeetCode.easyTenTasks5;

public class e3038 {
    /* 3038. Maximum Number of Operations With the Same Score I */
    public static void main(String[] args) {
        int[] nums = {2,2,3,2,4,2,3,3,1,3};
        System.out.println(maxOperations(nums));
    }

    public static int maxOperations(int[] nums) {
        int score = nums[0] + nums[1];
        int max = 1;
        for (int i = 2; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                int x = nums[i] + nums[++i];
                if (x == score){
                    max++;
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
