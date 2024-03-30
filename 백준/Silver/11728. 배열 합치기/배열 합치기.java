import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sorted = new int[arr1.length + arr2.length];
        int idx1 = 0;
        int idx2 = 0;
        int cur = 0;

        while (cur < sorted.length) {
            if (arr1[idx1] <= arr2[idx2]) {
                sorted[cur++] = arr1[idx1++];
            }
            else {
                sorted[cur++] = arr2[idx2++];
            }

            if (idx1 == arr1.length) {
                insertLeftValues(sorted, cur, arr2, idx2);
                break;
            }
            if (idx2 == arr2.length) {
                insertLeftValues(sorted, cur, arr1, idx1);
                break;
            }
        }

        String output = Arrays.stream(sorted).boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }

    private static void insertLeftValues(int[] target, int targetIndex, int[] source, int sourceIndex) {
        for (int idx = targetIndex; idx < target.length; idx++) {
            target[idx] = source[sourceIndex++];
        }
    }
}
