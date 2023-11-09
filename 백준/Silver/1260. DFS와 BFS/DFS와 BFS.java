import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int v;
    private static List<List<Integer>> originGraph;
    private static List<Integer> dfsRoot;
    private static List<Integer> bfsRoot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        v = Integer.parseInt(inputs[2]);

        originGraph = new ArrayList<>();
        originGraph.add(new ArrayList<>());
        for (int i=0; i<n; i++) {
            originGraph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            String[] inputEdge = br.readLine().split(" ");
            int start = Integer.parseInt(inputEdge[0]);
            int end = Integer.parseInt(inputEdge[1]);
            originGraph.get(start).add(end);
            originGraph.get(end).add(start);
        }

        for (int i=1; i<n+1; i++) {
            List<Integer> unsorted = originGraph.get(i);
            Collections.sort(unsorted);
        }

        dfsRoot = new ArrayList<>();
        dfs(v);

        bfsRoot = new ArrayList<>();
        bfs(v);

        String dfsResult = dfsRoot.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        String bfsResult = bfsRoot.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }

    public static void dfs(int vertex) {
        if (dfsRoot.contains(vertex)) {
            return;
        }

        dfsRoot.add(vertex);

        for (int next : originGraph.get(vertex)) {
            dfs(next);
        }
    }

    public static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        bfsRoot.add(vertex);
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : originGraph.get(now)) {
                if (!bfsRoot.contains(next)) {
                    bfsRoot.add(next);
                    queue.offer(next);
                }
            }
        }
    }
}