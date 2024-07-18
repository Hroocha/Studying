package tasksFromLeetCode.easyTenTasks5;

public class e2660 {
    /*2660. Determine the Winner of a Bowling Game*/

    public static void main(String[] args) {
        int[] one = {7};
        int[] two = {8};
        System.out.println(isWinner(one, two));
    }


    public static int isWinner(int[] player1, int[] player2) {
        int scoreOfPlayer1 = counter(player1);
        int scoreOfPlayer2 = counter(player2);
        if (scoreOfPlayer1 > scoreOfPlayer2) {
            return 1;
        } else if (scoreOfPlayer1 < scoreOfPlayer2) {
            return 2;
        } else {
            return 0;
        }
    }

    private static int counter(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int sum = array[0];
        if (array[0] == 10) {
            sum += array[1] * 2;
        } else {
            sum += array[1];
        }

        for (int i = 2; i < array.length; i++) {
            if (array[i - 1] == 10 || array[i - 2] == 10) {
                sum += array[i] * 2;
            } else {
                sum += array[i];
            }
        }

        return sum;
    }
}
