import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int countDividedFive(int input) {
        int count = 0;
        while (input % 5 == 0) {
            count++;
            input /= 5;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int count = 0;
        while (input >= 5) {
            count += countDividedFive(input);
            input--;
        }
        System.out.println(count);
    }
}