import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n + 1];

        initAnswers(n, ans);

        for (int index = 3; index <= n; index++) {
            ans[index] = (ans[index - 2] + ans[index - 1]) % 10007;
        }

        System.out.println(ans[n]);
    }

    private static void initAnswers(int n, int[] ans) {
        if (n >= 1) {
            ans[1] = 1;
        }
        if (n >= 2) {
            ans[2] = 2;
        }
    }
}