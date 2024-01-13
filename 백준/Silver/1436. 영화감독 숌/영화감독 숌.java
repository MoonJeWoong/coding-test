import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int count = 0;
        int answer = 0;
        int tmp = 666;
        while (true) {
            if (String.valueOf(tmp).contains("666")) {
               count++;
               answer = tmp;
            }
            if (count == input) {
                break;
            }
            tmp++;
        }

        System.out.println(answer);
    }
}