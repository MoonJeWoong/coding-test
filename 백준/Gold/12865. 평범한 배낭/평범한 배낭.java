import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        List<Product> products = new ArrayList<>();
        for (int iteration = 0; iteration < n; iteration++) {
            String[] productInputs = br.readLine().split(" ");
            products.add(new Product(Integer.parseInt(productInputs[0]), Integer.parseInt(productInputs[1])));
        }

        int[] dp = new int[k+1];
        for (Product product : products) {
            for (int index = k; index >= product.weight; index--) {
                dp[index] = Math.max(dp[index], dp[index - product.weight] + product.value);
            }
        }

        System.out.println(dp[k]);
    }
}

class Product {
    int weight;
    int value;

    public Product(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}