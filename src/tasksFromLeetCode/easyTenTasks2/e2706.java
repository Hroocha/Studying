package tasksFromLeetCode.easyTenTasks2;

import java.util.Arrays;

public class e2706 {
    /*2706. Buy Two Chocolates*/

    public static void main(String[] args) {
        int[] prices = {1, 2, 2};
        int money = 3;
        System.out.println(buyChoco(prices,money));
    }

    public static int buyChoco(int[] prices, int money) {
        if (prices.length < 2) {
            return money;
        }
        prices = Arrays.stream(prices).sorted().toArray();

        if (prices[0] + prices[1] <= money) {
            return money - prices[0] - prices[1];
        } else {
            return money;
        }
    }
}
