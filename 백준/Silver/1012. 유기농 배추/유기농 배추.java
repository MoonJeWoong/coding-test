import java.util.*;
import java.io.*;

public class Main {

    static int rowSize;
    static int colSize;
    static int[][] originMap;
    static int[][] checkMap;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.valueOf(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] initInput = br.readLine().split(" ");
            rowSize = Integer.valueOf(initInput[0]);
            colSize = Integer.valueOf(initInput[1]);
            int cabbageSize = Integer.valueOf(initInput[2]);

            originMap = new int[rowSize][colSize];
            checkMap = new int[rowSize][colSize];

            for (int j=0; j<cabbageSize; j++) {
                String[] cabbagePos = br.readLine().split(" ");
                originMap[Integer.valueOf(cabbagePos[0])][Integer.valueOf(cabbagePos[1])] = 1;
            }

            int ans = 0;

            for (int row=0; row<rowSize; row++) {
                for (int col=0; col<colSize; col++) {
                    if (originMap[row][col] == 1 && checkMap[row][col] != 1) {
                        checkMap[row][col] = 1;
                        bfs(row, col);
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    private static void bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row,col));

        while (!q.isEmpty()) {
            Node next = q.poll();
            for (int idx=0; idx<4; idx++) {
                int nRow = next.row + dx[idx];
                int nCol = next.col + dy[idx];

                if (nRow>=0 && nRow<rowSize && nCol>=0 && nCol<colSize) {
                    if (originMap[nRow][nCol] == 1 && checkMap[nRow][nCol] == 0) {
                        q.offer(new Node(nRow,nCol));
                        checkMap[nRow][nCol] = 1;
                    }
                }
            }
        }
    }

    private static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}