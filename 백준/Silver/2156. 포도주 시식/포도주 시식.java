import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n+1];
        int[] glasses = new int[n+1];

        for (int index = 1; index < n+1; index++) {
            glasses[index] = Integer.parseInt(br.readLine());
        }

        ans[1] = glasses[1];
        if (n >= 2) {
            ans[2] = glasses[1] + glasses[2];
        }

        for (int index = 3; index < n+1; index++) {
            ans[index] = Math.max(Math.max(ans[index-2], ans[index-3] + glasses[index-1]) + glasses[index], ans[index-1]);
        }
        System.out.println(ans[n]);
    }
}