package win.cents;

class Activity2 {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int sum = 4;
        System.out.println(cents(coins, sum));
    }

    public static int cents(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        for (int coin : coins) {

            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
                System.out.print(dp[j] + "");
            }
            System.out.println();
        }

        return dp[sum];
    }

}