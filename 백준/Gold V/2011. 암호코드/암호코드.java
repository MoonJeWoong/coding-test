import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");

        int[] dp = new int[inputs.length + 1];
        int[] encodedValues = new int [inputs.length + 1];
        for (int index = 1; index < inputs.length + 1; index++) {
            encodedValues[index] = Integer.parseInt(inputs[index-1]);
        }

        // 0에 대한 검증이 필요하다.
        if (doesExistInvalidZero(encodedValues)) {
            System.out.println("0");
            return;
        }

        initDpTable(dp, encodedValues);

        for (int index = 3; index < dp.length; index++) {
            if (encodedValues[index] == 0) {
                dp[index] = dp[index - 2];
                continue;
            }
            dp[index] = dp[index-1];
            if (encodedValues[index-1] != 0 && encodedValues[index-1] * 10 + encodedValues[index] <= 26) {
                dp[index] = (dp[index] + dp[index-2]) % 1_000_000;
            }
        }

        System.out.println(dp[dp.length-1]);
    }

    private static boolean doesExistInvalidZero(int[] values) {
        if (values[1] == 0) {
            return true;
        }
        for (int index = 1; index < values.length; index++) {
            if (values[index] == 0 && (values[index - 1] > 2 || values[index - 1] == 0)) {
                return true;
            }
        }
        return false;
    }

    private static void initDpTable(int[] dp, int[] encodedValues) {
        dp[1] = 1;
        if (dp.length == 2) {
            return;
        }

        dp[2] = 1;
        int decodedValueCode = encodedValues[1] * 10 + encodedValues[2];
        if (encodedValues[1] * 10 + encodedValues[2] <= 26 && decodedValueCode != 10 && decodedValueCode != 20) {
            dp[2] = 2;
        }
    }
}