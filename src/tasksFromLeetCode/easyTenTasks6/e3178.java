package tasksFromLeetCode.easyTenTasks6;

public class e3178 {
    /*3178. Find the Child Who Has the Ball After K Seconds*/

    public static void main(String[] args) {
        System.out.println(numberOfChild(2,3)); // 1
        System.out.println(numberOfChild(3,5)); // 1
        System.out.println(numberOfChild(5,6)); // 2
        System.out.println(numberOfChild(4,2)); // 2
        System.out.println(numberOfChild(3,3)); // 1
    }

    public static int numberOfChild(int n, int k) {
        if(k>=(2*(n-1))){
            k = k%(2*(n-1));
        }
        if(k>=(n-1)){
            k = k%(n-1);
            return (n-k-1);
        }
        else{
            return k;
        }
    }

}
