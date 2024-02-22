import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static int[] distances;
    private static boolean[] visited;
    private static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        distances = new int[n + 1];
        visited = new boolean[n + 1];
        initGraph(n);
        initDistances();

        for (int iter = 1; iter < m + 1; iter++) {
            String[] inputs = br.readLine().split(" ");
            Edge newEdge = new Edge(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
            graph.get(Integer.parseInt(inputs[0])).add(newEdge);
        }

        String[] mainInputs = br.readLine().split(" ");
        int startVert = Integer.parseInt(mainInputs[0]);
        int endVert = Integer.parseInt(mainInputs[1]);

        distances[startVert] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startVert, 0));

        while (!pq.isEmpty()) {
            Edge minDistanceVert = pq.poll();

            if (visited[minDistanceVert.vertex]) {
                continue;
            }

            visited[minDistanceVert.vertex] = true;
            for (Edge adjEdge : graph.get(minDistanceVert.vertex)) {
                if (distances[adjEdge.vertex] > distances[minDistanceVert.vertex] + adjEdge.cost) {
                    distances[adjEdge.vertex] = distances[minDistanceVert.vertex] + adjEdge.cost;
                    pq.offer(new Edge(adjEdge.vertex, distances[adjEdge.vertex]));
                }
            }
        }

        System.out.println(distances[endVert]);
    }

    private static void initGraph(int n) {
        graph.add(new ArrayList<>());
        for (int iter = 0; iter < n; iter++) {
            graph.add(new ArrayList<>());
        }
    }

    private static void initDistances() {
        for (int index = 1; index < distances.length; index++) {
            distances[index] = Integer.MAX_VALUE;
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}