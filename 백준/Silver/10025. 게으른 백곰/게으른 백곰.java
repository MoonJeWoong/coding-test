import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] points = new int[1_000_001];
        int n = inputs[0];
        int k = inputs[1];

        for (int idx = 0; idx < n; idx++) {
            inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            points[inputs[1]] = inputs[0];
        }

        if (k >= 1_000_001) {
            int sum = Arrays.stream(points)
                    .sum();
            System.out.println(sum);
            return;
        }

        int lt = 0, rt = k * 2 + 2;
        int answer = 0, sum = 0;
        for (int idx = lt; idx < rt; idx++) {
            sum += points[idx];
        }
        answer = sum;

        while (rt < 1_000_001) {
            sum = sum - points[lt++] + points[rt++];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}