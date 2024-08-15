import java.util.*;
import java.util.stream.*;

class Solution {
    private static Set<String> checkPoints = new HashSet<>();

    public int solution(String dirs) {
        int curX = 0;
        int curY = 0;
        
        for (char dir : dirs.toCharArray()) {
            int nextX = curX;
            int nextY = curY;
            
            if (dir == 'U') {
                nextX++;
            } else if (dir == 'D') {
                nextX--;
            } else if (dir == 'R') {
                nextY++;
            } else if (dir == 'L') {
                nextY--;
            }
            if (nextX >= -5 && nextX <= 5 && nextY >= -5 && nextY <= 5) {
                String route1 = curX + "" + curY + "" + nextX + "" + nextY;
                String route2 = nextX + "" + nextY + "" + curX + "" + curY;
                
                if (!checkPoints.contains(route1) && !checkPoints.contains(route2)) {
                    checkPoints.add(curX + "" + curY + "" + nextX + "" + nextY);
                }
                curX = nextX;
                curY = nextY;
            }
        }
        
        return checkPoints.size();
    }
    
}