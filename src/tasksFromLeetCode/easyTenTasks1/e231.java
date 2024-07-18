package tasksFromLeetCode.easyTenTasks1;

public class e231 {
    /* 231. Power of Two */

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-4));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1){
            return true;
        }
        do {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        } while (n != 1);
        return true;
    }
}
