package tasksFromLeetCode.easyTenTasks3;

public class e598 {
    /* 598. Range Addition II */

    public static void main(String[] args) {
        int[][] ops = {{16, 1}, {14, 3}, {14, 2}, {4, 1}, {10, 1}, {11, 1}, {8, 3}, {16, 2}, {13, 1}, {8, 3}, {2, 2},
                {9, 1}, {3, 1}, {2, 2}, {6, 3}};
        int m = 18;
        int n = 3;
        System.out.println(maxCount(m,n,ops));
    }
    public static int maxCount(int m, int n, int[][] ops) {
        int minY = m;
        int minX = n;

        for (int[] op : ops) {
            minY = Math.min(minY, op[0]);
            minX = Math.min(minX, op[1]);
        }

        return minX * minY;
    }
//    public int maxCount(int m, int n, int[][] ops) {
//        if (ops.length == 0){
//            return m * n;
//        }
//        int minMx = Integer.MAX_VALUE; // +
//        int MY = Integer.MAX_VALUE;
//        int minNx = Integer.MAX_VALUE; // +
//        int NY = Integer.MAX_VALUE;
//
//        for (int[] f : ops) {
//            if (f[0] < minMx) {
//                minMx = f[0];
//                MY = f[1];
//            } else if(f[0] == minMx){
//                MY = Math.min(f[1], MY);
//            }
//            if (f[1] < minNx) {
//                minNx = f[1];
//                NY = f[0];
//            } else if(f[1] == minNx){
//                NY = Math.min(f[0], NY);
//            }
//        }
//        int minForM = minMx * MY;
//        int minForN = minNx * NY;
//
//        if (minForM == minForN) {
//            return Math.abs(minMx * MY);
//        } else {
//            return minMx * minNx;
//        }
//    }
}
