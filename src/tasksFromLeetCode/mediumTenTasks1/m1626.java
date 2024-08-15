package tasksFromLeetCode.mediumTenTasks1;


import java.util.Arrays;
import java.util.Comparator;

public class m1626 {
    /*1760. Minimum Limit of Balls in a Bag*/
    static Integer a;

    public static void main(String[] args) {
//        int[] scores = {1,2,3,5};
//        int[] ages = {8,9,10,1};
//        int[] scores = {4,5,6,5};
//        int[] ages = {2,1,2,1};
//        int[] scores = {1,1,1,1,1,1,1,1,1,1};
//        int[] ages = {811,364,124,873,790,656,581,446,885,134};
        int[] scores = {1,3,7,3,2,4,10,7,5};
        int[] ages =   {4,5,2,1,1,2,4,1,4};
        System.out.println(bestTeamScore(scores, ages));
    }


    public static int bestTeamScore(int[] scores, int[] ages) {
        if (ages.length == 1) {
            return scores[0];
        }
        int[][] agesAndScores = new int[ages.length][ages.length];
        for (int i = 0; i < ages.length; i++) {
            agesAndScores[i] = new int[]{ages[i], scores[i]};
        }
        agesAndScores = Arrays.stream(agesAndScores)
//                .sorted(Comparator.comparingInt(a -> a[1])) // Сравнение по 2-ому элементу то же что и .sorted(a, b) -> Integer.compare(a[1], b[1])
                .sorted((a, b) -> {
                    int compareFirst = Integer.compare(a[1], b[1]); // Сравнение по первому элементу
                    if (compareFirst != 0) {
                        return compareFirst; // Если первый элементы различаются, вернуть результат
                    }
                    return Integer.compare(a[0], b[0]); // Иначе, сравнить по второму элементу
                })
                .toArray(int[][]::new);

        if(agesAndScores[0][1] == agesAndScores[ages.length-1][1]){
            agesAndScores = Arrays.stream(agesAndScores)
                    .sorted(Comparator.comparingInt(a -> a[0]))
                    .toArray(int[][]::new);
        }
        for (int[] subArray : agesAndScores) {
            System.out.println(Arrays.toString(subArray));
        }

        int maxScore = 0;
        for (int i = 1; i < agesAndScores.length; i++) {
            int curScores = agesAndScores[i][1];
            int sumOfScores = 0;
            for (int j = 0; j < i; j++) {
                if (agesAndScores[i][0] >= agesAndScores[j][0]) {  // возраст текущего больше или равен предыдущ.
                    sumOfScores = agesAndScores[j][1] + curScores;
                    if (sumOfScores > agesAndScores[i][1]) agesAndScores[i][1] = sumOfScores;

                }
            }
            maxScore = Math.max(maxScore, agesAndScores[i][1]);
        }

        return maxScore;
    }
}


