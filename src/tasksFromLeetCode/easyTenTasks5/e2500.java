package tasksFromLeetCode.easyTenTasks5;

import java.util.Arrays;

public class e2500 {
    /*2500. Delete Greatest Value in Each Row */

    public static void main(String[] args) {
        int [][] arr1 = {{1,2,4}, {3,3,1}};
        System.out.println(deleteGreatestValue(arr1));
    }
    public static int deleteGreatestValue(int[][] grid) {
        int answer = 0;
        int length = grid.length; //2
        int maxArrLength = 0; //3
        while (length > 0){
            int arrLength = grid[length-1].length;
            if (arrLength > maxArrLength) {
                maxArrLength = arrLength;
            }
            grid[length-1] = Arrays.stream(grid[length-1]).sorted().toArray();
            length--;
        }
        for (int i = 0; i < maxArrLength; i++) {
            int value = 0;

            for (int [] arr : grid) {
                if (arr.length >= i){
                    if (arr[i] >= value){
                        value = arr[i];
                    }
                }
            }
            answer += value;
        }
        return answer;
    }
}
