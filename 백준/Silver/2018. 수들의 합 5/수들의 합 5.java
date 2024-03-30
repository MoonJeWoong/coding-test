import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n==1 || n==2) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[n/2 + 1];

        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = idx + 1;
        }

        int lt = 0;
        int rt = 0;
        int sum = 0;
        int count = 1;

        while (true) {
            if (sum > n) {
                sum -= arr[lt++];
            }
            else if (rt == arr.length) {
                break;
            }
            else {
                sum += arr[rt++];
            }
            if (sum == n) {
                count++;
            }
        }
        System.out.println(count);
    }
}