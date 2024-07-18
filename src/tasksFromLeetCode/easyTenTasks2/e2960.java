package tasksFromLeetCode.easyTenTasks2;

public class e2960 {
    /*2960. Count Tested Devices After Test Operations*/
    public static void main(String[] args) {
        int [] batteryPercentages = {1,1,2,1,3};
        System.out.println(countTestedDevices(batteryPercentages));
    }

    public static int countTestedDevices(int[] batteryPercentages) {
        int answer = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                answer++;
                for (int j = i + 1; j < batteryPercentages.length; j++) {
                    if (batteryPercentages[j] > 0) {
                        batteryPercentages[j]--;
                    }
                }
            }
        }
        return answer;
    }
}
