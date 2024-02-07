import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] triangleNums = new int[45];

        for (int index = 0; index < triangleNums.length; index++) {
            triangleNums[index] = (index + 1) * (index + 2) / 2;
        }

        int[] targetNums = new int[n];
        for (int iteration = 0; iteration < n; iteration++) {
            targetNums[iteration] = Integer.parseInt(br.readLine());
        }

        for (int target : targetNums) {
            int answer = search(target, triangleNums);
            System.out.println(answer);
        }
    }

    private static int search(int targetNum, int[] triangleNums) {
        for (int index1 = 0; index1 < triangleNums.length; index1++) {
            for (int index2 = index1; index2 < triangleNums.length; index2++) {
                for (int index3 = index2; index3 < triangleNums.length; index3++) {
                    if (targetNum == triangleNums[index1] + triangleNums[index2] + triangleNums[index3]) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}