import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static int[] sets;
    private static List<String[]> inputLines = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        sets = new int[n+1];
        for (int index = 1; index < sets.length; index++) {
            sets[index] = index;
        }

        for (int iter = 0; iter < m; iter++) {
            inputLines.add(br.readLine().split(" "));
        }

        for (String[] inputLine : inputLines) {
            if (Integer.parseInt(inputLine[0]) == 0) {
                union(Integer.parseInt(inputLine[1]), Integer.parseInt(inputLine[2]));
            }
            else {
                if(find(Integer.parseInt(inputLine[1])) == find(Integer.parseInt(inputLine[2]))) {
                    System.out.println("YES");
                    continue;
                }
                System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        int groupA = find(a);
        int groupB = find(b);
        if (groupA != groupB) sets[groupA] = groupB;
    }

    private static int find(int value) {
        if (value == sets[value]) return value;
        return sets[value] = find(sets[value]);
    }
}