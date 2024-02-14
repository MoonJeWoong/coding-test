import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static int n;
    private static int m;
    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int iter = 0; iter < n+1; iter++) {
            graph.add(new ArrayList<>());
        }

        for (int iter = 0; iter < m; iter++) {
            String[] edges = br.readLine().split(" ");
            int vertex1 = Integer.parseInt(edges[0]);
            int vertex2 = Integer.parseInt(edges[1]);
            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        for (int start = 1; start < n+1; start++) {
            if (!visited[start]) {
                dfs(start);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;
        for(int adjacentVertex : graph.get(start)) {
            dfs(adjacentVertex);
        }
    }
}