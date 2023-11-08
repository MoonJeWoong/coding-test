import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] originMap;
    private static int[][] checkMap;
    private static int[] dx = {1,0,-1,0};
    private static int [] dy = {0,1,0,-1};
    private static int maxDepth;
    private static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        originMap = new int[n][n];

        inputOriginMap(br);
        ans = 1;

        maxDepth=Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                maxDepth = Math.max(maxDepth, originMap[i][j]);
            }
        }

        for (int depth=1; depth<maxDepth; depth++) {
            checkMap = new int[n][n];

            // 기존 맵 -1씩 하면서
            changeOriginMap();

            // bfs 수행하면서 몇개 나오는지 카운트
            Queue<Node> queue = new LinkedList<>();
            int safeAreaSize = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (originMap[i][j] > 0 && checkMap[i][j] == 0) {
                        queue.offer(new Node(i,j));
                        checkMap[i][j] = 1;
                        while (!queue.isEmpty()) {
                            Node now = queue.poll();
                            for (int k=0; k<4; k++) {
                                int nx = now.x + dx[k];
                                int ny = now.y + dy[k];
                                if (nx>=0 && nx<n && ny>=0 && ny<n) {
                                    if (originMap[nx][ny] > 0 && checkMap[nx][ny] == 0) {
                                        queue.offer(new Node(nx, ny));
                                        checkMap[nx][ny]=1;
                                    }
                                }
                            }
                        }
                        safeAreaSize++;
                    }
                }
            }

            // 최대 개수 갱신
            ans = Math.max(ans, safeAreaSize);
        }

        System.out.println(ans);
    }

    private static void changeOriginMap() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (originMap[i][j] > 0) {
                    originMap[i][j] = originMap[i][j] - 1;
                }
            }
        }
    }

    private static void inputOriginMap(BufferedReader br) throws IOException {
        for (int i=0; i<n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
            originMap[i] = line;
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
