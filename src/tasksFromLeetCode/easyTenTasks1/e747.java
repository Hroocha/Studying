package tasksFromLeetCode.easyTenTasks1;

public class e747 {
    /* 747. Largest Number At Least Twice of Others*/

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1};
        System.out.println(dominantIndex(arr));
    }

    public static int dominantIndex(int[] nums) {

        int max = nums[0];
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int count = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != max && nums[j] * 2 <= max) {
                count++;
            }
        }

        if (count == nums.length - 1) {
            return maxIndex;
        } else {
            return -1;
        }
    }

//    public static int dominantIndex(int[] nums) {
//        int [] arrNew = Arrays.stream(nums).sorted().toArray();
//        int max = arrNew[arrNew.length - 1];
//        int prevMax = arrNew[arrNew.length - 2];
//        if (prevMax == 0 & max != 0){
//            return IntStream.range(0, nums.length).filter(n -> nums[n] == max).findFirst().orElse(-1);
//        }
//        if( prevMax !=0 && max / prevMax >= 2){
//            return IntStream.range(0, nums.length).filter(n -> nums[n] == max).findFirst().orElse(-1);
//        } else return -1;
//    }

}
