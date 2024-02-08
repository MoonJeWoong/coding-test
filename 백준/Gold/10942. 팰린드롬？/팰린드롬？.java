import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[n][n];

        for (int index = 0; index < n; index++) {
            dp[index][index] = 1;
            if (index < n-1) {
                if (sequence[index] == sequence[index+1]) {
                    dp[index][index+1] = 1;
                }
            }
        }

        for (int len = 2; len < n; len++) {
            for (int startIndex = 0; startIndex < n - len; startIndex++) {
                if (sequence[startIndex] == sequence[startIndex + len]
                        && dp[startIndex + 1][startIndex + len - 1] == 1) {
                    dp[startIndex][startIndex + len] = 1;
                }
            }
        }

        int caseCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int iter = 0; iter < caseCount; iter++) {
            String[] caseInputs = br.readLine().split(" ");
            int startPos = Integer.parseInt(caseInputs[0]) - 1;
            int endPos = Integer.parseInt(caseInputs[1]) - 1;
            if (dp[startPos][endPos] == 1) {
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }
}