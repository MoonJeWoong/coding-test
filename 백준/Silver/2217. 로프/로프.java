import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int iter = 0; iter < n; iter++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        for (int index = 0; index < n; index++) {
            int tmp = pq.poll() * (n - index);
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}