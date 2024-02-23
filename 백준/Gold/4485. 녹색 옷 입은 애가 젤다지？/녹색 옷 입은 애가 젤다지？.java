import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map;
    private static int[][] distances;
    private static boolean[][] checked;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static List<List<List<Node>>> graph;
    private static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            init(br, n);

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, map[0][0]));

            while (!pq.isEmpty()) {
                Node current = pq.poll();

                if (checked[current.row][current.col]) {
                    continue;
                }

                checked[current.row][current.col] = true;
                for (Node adjNode : graph.get(current.row).get(current.col)) {
                    if (distances[adjNode.row][adjNode.col] > distances[current.row][current.col] + adjNode.cost) {
                        distances[adjNode.row][adjNode.col] = distances[current.row][current.col] + adjNode.cost;
                        pq.offer(new Node(adjNode.row, adjNode.col, distances[adjNode.row][adjNode.col]));
                    }
                }
            }

            answers.add(distances[n-1][n-1]);
        }

        for (int iter = 0; iter < answers.size(); iter++) {
            System.out.println(String.format("Problem %d: %d", iter+1, answers.get(iter)));
        }
    }

    private static void init(BufferedReader br, int n) throws IOException {
        map = new int[n][n];
        distances = new int[n][n];
        checked = new boolean[n][n];
        graph = new ArrayList<>();

        for (int iter = 0; iter < n; iter++) {
            map[iter] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.fill(distances[iter], Integer.MAX_VALUE);
            graph.add(new ArrayList<>());
            for (int iter2 = 0; iter2 < n; iter2++) {
                graph.get(iter).add(new ArrayList<>());
            }
        }
        distances[0][0] = map[0][0];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                for (int iter = 0; iter < 4; iter++) {
                    int nextRow = row + dx[iter];
                    int nextCol = col + dy[iter];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                        graph.get(row).get(col).add(new Node(nextRow, nextCol, map[nextRow][nextCol]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int row;
    int col;
    int cost;

    public Node(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}