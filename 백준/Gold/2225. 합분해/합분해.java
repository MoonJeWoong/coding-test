import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final int DIVIDE_NUM = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[][] dp = new int[k+1][n+1];

        // dp 테이블 초기화
        for (int index = 0; index <= n; index++) {
            dp[1][index] = 1;
        }

        // 각 행별로 합 구하기
        for (int rowIndex = 2; rowIndex <= k; rowIndex++) {
            for (int colIndex = 0; colIndex <= n; colIndex++) {
                dp[rowIndex][colIndex] = calculateDpValue(dp, rowIndex, colIndex);
            }
        }

        System.out.println(dp[k][n]);

    }

    private static int calculateDpValue(int[][] dp, int row, int col) {
        int sum = 0;
        for (int colIndex = 0; colIndex <= col; colIndex++) {
            sum = (sum + dp[row - 1][colIndex]) % DIVIDE_NUM;
        }
        return sum;
    }
}