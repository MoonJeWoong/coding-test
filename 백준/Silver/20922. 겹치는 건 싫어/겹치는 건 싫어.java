import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = inputs[1];
        int[] seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int [] count = new int[100_001];

        int lt = 0, rt = 1;
        count[seq[lt]] = 1;
        int answer = 1;
        int size = 1;
        while (rt < seq.length) {
            if (count[seq[rt]] >= k) {
                count[seq[lt++]]--;
                size--;
            } else if (count[seq[rt]] < k) {
                count[seq[rt]]++;
                size++;
                rt++;
            }
            answer = Math.max(answer, size);
        }
        System.out.println(answer);
    }
}