import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = br.readLine();
        String target = br.readLine();

        String originStr = firstInput.replaceAll("[0-9]", "");
        if (originStr.contains(target)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}