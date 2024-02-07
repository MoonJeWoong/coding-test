import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] coins = new int[n];
        for (int index = 0; index < n; index++) {
            coins[index] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int index = coin; index < k + 1; index++) {
                dp[index] += dp[index - coin];
            }
        }

        System.out.println(dp[k]);
    }
}