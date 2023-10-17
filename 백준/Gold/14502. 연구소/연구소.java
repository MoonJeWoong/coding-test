import java.util.*;
import java.io.*;

public class Main {

    static final int[] dx = {1, 0, 0, -1};
    static final int[] dy = {0, 1, -1, 0};
    static int[][] originalMap;
    static int n, m;
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bf.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);
        originalMap = new int[n][m];

        for (int i=0; i<n; i++) {
            String[] row = bf.readLine().split(" ");
            for (int j=0; j<m; j++) {
                originalMap[i][j] = Integer.parseInt(row[j]);
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    public static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(wallCnt+1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (originalMap[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }

        int[][] copyMap = new int[n][m];

        for (int i=0; i<n; i++) {
            copyMap[i] = Arrays.copyOf(originalMap[i], originalMap[i].length);
        }

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int k=0; k<4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }

        calculateSafeZone(copyMap);
    }

    private static void calculateSafeZone(int[][] map) {
        int safeZone = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
