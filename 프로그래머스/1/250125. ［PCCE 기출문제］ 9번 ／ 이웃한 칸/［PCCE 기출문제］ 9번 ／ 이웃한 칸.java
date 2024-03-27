import java.util.*;

class Solution {
    
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        for (int idx = 0; idx < 4; idx++) {
            int nextHeight = h + dx[idx];
            int nextWidth = w + dy[idx];
            if (nextHeight < 0 || nextHeight >= board.length || nextWidth < 0 || nextWidth >= board[0].length) {
                continue;
            }
            if (color.equals(board[nextHeight][nextWidth])) {
                answer++;
            }
        }
        return answer;
    }
}
