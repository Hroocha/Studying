package tasksFromLeetCode.easyTenTasks2;

public class e1732 {
    /*1732. Find the Highest Altitude*/

    public static void main(String[] args) {
        int [] arr = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(arr));
    }
    public static int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length + 1];
        int max = 0;
        for (int i = 0; i < altitude.length - 1; i++) {
            altitude[i + 1] = altitude[i] + gain[i];
            if (max < altitude[i + 1]) {
                max = altitude[i + 1];
            }
        }
        return max;
    }
}
