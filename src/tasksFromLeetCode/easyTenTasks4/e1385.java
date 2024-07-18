package tasksFromLeetCode.easyTenTasks4;

public class e1385 {
    /*1385. Find the Distance Value Between Two Arrays */

    public static void main(String[] args) {
        int [] arr1 = {4,5,8};
        int [] arr2 = {10,9,1,8};
        int d = 2;
        System.out.println(findTheDistanceValue(arr1,arr2,d));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int wrong = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d){
                    wrong++;
                    break;
                }
            }
        }
        return arr1.length - wrong;
    }

}
