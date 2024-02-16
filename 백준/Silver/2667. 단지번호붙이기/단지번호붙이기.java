import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int countOfGroups = 0;
    private static int countOfHouses = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> answers = new ArrayList<>();

        for (int iter = 0; iter < n; iter++) {
            map[iter] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (map[row][col] == 1 && !visited[row][col]) {
                    countOfHouses = 0;
                    dfs(row, col);
                    countOfGroups++;
                    answers.add(countOfHouses);
                }
            }
        }

        answers.sort(Comparator.naturalOrder());
        System.out.println(countOfGroups);
        for (int num : answers) {
            System.out.println(num);
        }
    }

    public static void dfs(int row, int col) {
        if (map[row][col] != 1 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        countOfHouses++;
        for (int index = 0; index < 4; index++) {
            int nextRow = row + dx[index];
            int nextCol = col + dy[index];
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                dfs(nextRow, nextCol);
            }
        }
    }
}