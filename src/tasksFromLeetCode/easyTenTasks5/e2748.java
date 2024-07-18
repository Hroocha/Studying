package tasksFromLeetCode.easyTenTasks5;

public class e2748 {
    /*2748. Number of Beautiful Pairs */
    public static void main(String[] args) {
        int [] arr = {2,5,1,4};
        System.out.println(countBeautifulPairs(arr));
    }

    public static int countBeautifulPairs(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            String first = String.valueOf(nums[i]);
            int one = Integer.parseInt(String.valueOf(first.charAt(0)));
            for (int j = i + 1; j < nums.length; j++) {
                String second = String.valueOf(nums[j]);
                int two = Integer.parseInt(String.valueOf(second.charAt(second.length()-1)));

                int gcdCounter = 0;
                int divisor = Math.min(one,two);
                while (divisor > 0) {
                    if (one % divisor == 0 && two % divisor == 0) {
                        gcdCounter++;
                    }
                    divisor--;
                }
                if (gcdCounter == 1){
                    counter++;
                }
            }
        }
        return counter;
    }

}
