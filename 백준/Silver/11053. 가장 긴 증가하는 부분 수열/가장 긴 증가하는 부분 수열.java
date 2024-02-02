import java.io.*;
import java.util.*;

public class Main {

    public static int[] createZeroIndexArray(int[] array) {
        int[] result = new int[array.length+1];
        for (int index = 1; index < result.length; index++) {
            result[index] = array[index-1];
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] zeroIndexSequence = createZeroIndexArray(sequence);

        int[] ans = new int[n+1];
        Arrays.fill(ans, 1, ans.length, 1);

        for (int index = 2; index < n+1; index++) {
            for (int cursor = 0; cursor < index; cursor++) {
                if (zeroIndexSequence[cursor] < zeroIndexSequence[index]) {
                    ans[index] = Math.max(ans[index], ans[cursor] + 1);
                }
            }
        }

        int answer = Arrays.stream(ans)
                .max()
                .getAsInt();

        System.out.println(answer);
    }
}