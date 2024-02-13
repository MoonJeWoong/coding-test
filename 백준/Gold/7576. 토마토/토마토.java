import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static int n;
    private static int m;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[1]);
        m = Integer.parseInt(inputs[0]);

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int iter = 0; iter < n; iter++) {
            int[] inputRow = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[iter] = inputRow;
        }

        // 모든 요소 값중에 0이 없으면, 0을 출력하고 프로그램 종료
        if (areTomatoesAllGrown()) {
            System.out.println(0);
            return;
        }

        // 아니라면 그대로 bfs
        Deque<Position> queue = new LinkedList<>();
        initQueue(queue);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int iter = 0; iter < queueSize; iter++) {
                Position currentPosition = queue.poll();
                for (int index = 0; index < 4; index ++) {
                    int nextRow = currentPosition.row + dx[index];
                    int nextCol = currentPosition.col + dy[index];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                        if (board[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                            queue.offer(new Position(nextRow, nextCol));
                            board[nextRow][nextCol] = 1;
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }
            answer++;
            if (areTomatoesAllGrown()) {
                break;
            }
        }

        if (areTomatoesAllGrown()) {
            System.out.println(answer);
        }
        else {
            System.out.println(-1);
        }

    }

    private static void initQueue(Deque<Position> queue) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] == 1) {
                    queue.offer(new Position(row, col));
                    visited[row][col] = true;
                }
            }
        }
    }

    private static boolean areTomatoesAllGrown() {
        for (int[] row : board) {
            for (int index = 0; index < row.length; index++) {
                if (row[index] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}