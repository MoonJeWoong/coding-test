import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[1]);

        int[] visitors = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lt = 0;
        int rt = n;
        int sum = calculateSum(visitors, lt, rt);
        int answer = sum;
        int count = 1;

        while (rt < visitors.length) {
            sum -= visitors[lt++];
            sum += visitors[rt++];
            if (answer == sum) {
                count++;
                continue;
            }
            if (answer < sum) {
                answer = sum;
                count = 1;
            }
        }

        if (answer == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(answer);
            System.out.println(count);
        }
    }

    private static int calculateSum(int[] visitors, int lt, int rt) {
        int sum = 0;
        for (int idx = lt; idx < rt; idx++) {
            sum += visitors[idx];
        }
        return sum;
    }
}