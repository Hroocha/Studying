package tasksFromLeetCode.easyTenTasks4;

public class e2980 {
    /* 2980. Check if Bitwise OR Has Trailing Zeros */

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(hasTrailingZeros(nums));
    }

    public static boolean hasTrailingZeros(int[] nums) {
        int sumOfEven = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sumOfEven++;
            }
            if (sumOfEven >= 2) {
                return true;
            }
        }
        return false;
    }
}
