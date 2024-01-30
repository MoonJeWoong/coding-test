import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 2) {
            if (n == 1) {
                System.out.println(1);
            }
            if (n == 2) {
                System.out.println(3);
            }
            return;
        }

        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[2] = 3;

        for (int index = 3; index < n + 1; index++) {
            ans[index] = (ans[index - 1] + 2 * ans[index - 2]) % 10007;
        }

        System.out.println(ans[n]);
    }
}