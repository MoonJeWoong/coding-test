import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] originalMap;
    private static int[][] checkMap;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        originalMap = new int[n][m];
        checkMap = new int[n][m];

        initOriginalMap(br, n, m);

        bfs();

        System.out.println(checkMap[n-1][m-1]);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));
        checkMap[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx>=0 && nx<n && ny>=0 && ny<m) {
                    if (checkMap[nx][ny] == 0 && originalMap[nx][ny] == 1) {
                        queue.offer(new Node(nx, ny));
                        checkMap[nx][ny] = checkMap[now.x][now.y] + 1;
                    }
                }
            }
        }
    }

    private static void initOriginalMap(BufferedReader br, int n, int m) throws IOException {
        for (int i=0; i< n; i++) {
            String[] inputLine = br.readLine().split("");
            int[] tmpLine = new int[m];
            for (int j=0; j< m; j++) {
                tmpLine[j] = Integer.parseInt(inputLine[j]);
            }
            originalMap[i] = tmpLine;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
