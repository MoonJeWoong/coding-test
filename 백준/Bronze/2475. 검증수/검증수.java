import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .map(val -> (int)Math.pow(val,2))
                .sum();

        System.out.println(sum%10);
    }
}