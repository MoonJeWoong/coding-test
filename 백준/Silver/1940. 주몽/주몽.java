import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] sorted = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int lt = 0, rt = sorted.length - 1;
        int sum = 0, answer = 0;

        while (lt < rt) {
            sum = sorted[lt] + sorted[rt];
            if (sum == m) {
                answer++;
            }
            if (sum <= m) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(answer);
    }
}