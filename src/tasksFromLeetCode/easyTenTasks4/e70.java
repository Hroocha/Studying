package tasksFromLeetCode.easyTenTasks4;

public class e70 {
    /* 70. Climbing Stairs*/

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if (n == 0) return 1;
        int prevWays = 1;
        int prevPrevWays = 1;
        int totalWays = 0;
        for (int i = 2; i <= n; i++) {
            totalWays = prevWays + prevPrevWays;
            prevPrevWays = prevWays;
            prevWays = totalWays;
        }
        return totalWays;
    }

}
