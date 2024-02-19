import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int[] dp = new int[k + 1];
        int[] coins = new int[n + 1];

        for (int iter = 0; iter < n; iter++) {
            coins[iter + 1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        if (k < coins[1]) {
            System.out.println(-1);
            return;
        }

        dp[0] = 0;
        for (int index = 1; index < coins[1]; index++) {
            dp[index] = -1;
        }
        dp[coins[1]] = 1;

        for (int index = coins[1] + 1; index <= k; index++) {
            for (int coinIndex = 1; coinIndex < coins.length; coinIndex++) {
                if (index - coins[coinIndex] < 0) {
                    break;
                }
                if (dp[index] == 0 && dp[index - coins[coinIndex]] == -1) {
                    dp[index] = -1;
                    continue;
                }
                if (dp[index - coins[coinIndex]] >= 0) {
                    if (dp[index] == 0 || dp[index] == -1) {
                        dp[index] = dp[index - coins[coinIndex]] + 1;
                        continue;
                    }
                    dp[index] = Math.min(dp[index], dp[index - coins[coinIndex]] + 1);
                }
            }
            if (dp[index] == 0) {
                dp[index] = -1;
            }
        }

        System.out.println(dp[k]);
    }
}