import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n+1];
        initAnswer(n, ans);

        for (int index = 2; index <= n; index++) {
            if (index % 3 == 0) {
                ans[index] = Math.min(ans[index / 3] + 1, ans[index]);
            }
            if (index % 2 == 0) {
                ans[index] = Math.min(ans[index / 2] + 1, ans[index]);
            }
            ans[index] = Math.min(ans[index-1] + 1, ans[index]);
        }

        System.out.println(ans[n]);
    }

    private static void initAnswer(int n, int[] ans) {
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        if (n >= 1) {
            ans[1] = 0;
        }
    }
}