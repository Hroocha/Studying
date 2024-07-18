package tasksFromLeetCode.easyTenTasks1;

public class e136 {
    /* 136. Single Number*/

    public static void main(String[] args) {
        int[] nums = {4,9,5};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }


//    public static int singleNumber(int[] nums) {
//        if (nums.length == 1){
//            return nums[0];
//        }
//        nums = Arrays.stream(nums).sorted().toArray();
//        if(nums[0] != nums[1]){
//            return nums[0];
//        }
//        if(nums[nums.length-1] != nums[nums.length-2]){
//            return nums[nums.length-1];
//        }
//        for (int i = 1; i < nums.length-1; i++) {
//            if(nums[i] != nums[i+1] && nums[i] != nums[i-1])
//                return nums[i];
//        }
//        return -1;
//    }
}
