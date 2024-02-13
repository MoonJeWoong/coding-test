import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        Counseling[] counselings = new Counseling[n+1];
        int[] dp = new int[n + 1];

        for (int iter = 1; iter < counselings.length; iter++) {
            String[] inputs = br.readLine().split(" ");
            counselings[iter] = new Counseling(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }

        if (counselings[n].cost == 1) {
            dp[n] = counselings[n].amount;
        }

        int currentMaxAmount = dp[n];
        for (int index = n-1; index > 0; index--) {
            if (index + (counselings[index].cost - 1) <= n) {
                dp[index] = counselings[index].amount;
                if (index + counselings[index].cost <= n) {
                    dp[index] += dp[index + counselings[index].cost];
                }
            }
            dp[index] = Math.max(currentMaxAmount, dp[index]);
            currentMaxAmount = dp[index];
        }

        int maxAmount = Arrays.stream(dp)
                .max()
                .getAsInt();
        System.out.println(maxAmount);
    }
}

class Counseling {
    int cost;
    int amount;

    public Counseling(int cost, int amount) {
        this.cost = cost;
        this.amount = amount;
    }
}