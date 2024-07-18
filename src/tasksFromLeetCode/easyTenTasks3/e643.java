package tasksFromLeetCode.easyTenTasks3;

public class e643 {
    /* 643. Maximum Average Subarray I*/

    public static void main(String[] args) {
        int [] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums,k));
    }

        public static double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int maxSum=sum;
        int s=0;
        int e=k;
        while(e<nums.length){
            sum-=nums[s];
            s++;
            sum+=nums[e];
            e++;
            maxSum=Math.max(maxSum,sum);
        }
        return (double) maxSum/k;
    }
//    public static double findMaxAverage(int[] nums, int k) {
//        double answer = Integer.MIN_VALUE;
//        double sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += nums[i];
//        }
//        for (int i = k; i < nums.length; i++) {
//            int y = i;
//            int x = k;
//            while (x != 0) {
//                sum += nums[y++];
//                x--;
//            }
//            if (sum / k > answer) {
//                answer = sum / k;
//            }
//            sum = 0;
//        }
//        return answer;
//    }
}
