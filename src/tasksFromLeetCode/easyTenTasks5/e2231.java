package tasksFromLeetCode.easyTenTasks5;

public class e2231 {

    /*2231. Largest Number After Digit Swaps by Parity*/
    public static void main(String[] args) {
        System.out.println(largestInteger(737));
    }

    public static int largestInteger(int num) {
        char [] nums = String.valueOf(num).toCharArray();
        for (int i = 0; i + 1 < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && (nums[j] - nums[i]) % 2 == 0){
                    swap(nums,i,j);
                }
            }
        }
        return Integer.parseInt(new String(nums));
    }

    public static void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
