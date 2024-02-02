import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n + 1];
        int[] steps = new int[n + 1];

        for (int index = 1; index < n + 1; index++) {
            steps[index] = Integer.parseInt(br.readLine());
        }

        ans[1] = steps[1];
        if (n>=2) {
            ans[2] = steps[1] + steps[2];
        }

        for (int index = 3; index < n + 1; index++) {
            ans[index] = Math.max(ans[index - 2], ans[index - 3] + steps[index - 1]) + steps[index];
        }
        System.out.println(ans[n]);
    }
}