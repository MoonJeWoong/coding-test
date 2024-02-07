import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final int MAX_VALUE = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        String[] numbers = new String[MAX_VALUE];
        for (int num = 0; num < MAX_VALUE; num++) {
            numbers[num] = String.valueOf(num+1);
        }

        for (String number : numbers) {
            int sum = Integer.valueOf(number);
            for (char digit : number.toCharArray()) {
                sum += Integer.parseInt(String.valueOf(digit));
            }
            if (sum == n) {
                ans = Integer.parseInt(number);
                break;
            }
        }

        System.out.println(ans);
    }
}