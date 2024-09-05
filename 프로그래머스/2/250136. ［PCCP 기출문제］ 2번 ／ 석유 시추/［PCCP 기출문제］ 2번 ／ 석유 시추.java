import java.util.*;
import java.util.stream.*;

class Solution {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    private static int[] cachedColumns;
    private static int landRowSize;
    private static int landColSize;
    
    public int solution(int[][] land) {
        cachedColumns = new int[land[0].length];
        landRowSize = land.length;
        landColSize = land[0].length;
        
        // 전체 land 순회하면서 bfs로 각 영역 크기 계산하고 해당하는 column에 너비 추가하기
        initColumns(land);
        
        return  Arrays.stream(cachedColumns)
            .max()
            .getAsInt();
    }
    
    private void initColumns(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        
        for (int row = 0; row < landRowSize; row++) {
            for (int col = 0; col < landColSize; col++) {
                if (land[row][col] == 1 && !visited[row][col]) {
                    cachingWithBfs(land, visited, row, col);
                }
            }
        }
    }
    
    private void cachingWithBfs(int[][] land, boolean[][]visited, int row, int col) {
        Set<Integer> targets = new HashSet<>();
        
        Deque<int[]> dq = new LinkedList<>();
        dq.offerLast(new int[] {row, col});
        visited[row][col] = true;
        targets.add(col);
        int area = 1;
        
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            
            for (int idx = 0; idx < 4; idx++) {
                int nextRow = cur[0] + dx[idx];
                int nextCol = cur[1] + dy[idx];
                if (nextRow >= 0 && nextRow < landRowSize && nextCol >= 0 && nextCol < landColSize && land[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == false) {
                    area++;
                    dq.offerLast(new int[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                    targets.add(nextCol);
                }
            }
        }
        
        for (int targetCol : targets) {
            cachedColumns[targetCol] += area;
        }
    }
}