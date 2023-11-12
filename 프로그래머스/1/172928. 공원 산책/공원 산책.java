import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        // tmp 지점 저장
        // routes 순회 돌면서 tmp 이동시키며 park 확인
        // 장애물 or park 외로 나가면 continue
        // 정상 이동 시 ans 포지션 업데이트

        Map<String, Position> directionMapper = new HashMap<>();
        directionMapper.put("E", new Position(0,1));
        directionMapper.put("W", new Position(0,-1));
        directionMapper.put("N", new Position(-1,0));
        directionMapper.put("S", new Position(1,0));

        Position cur = initStart(park);

        for (String move : routes) {
            String[] commands = move.split(" ");
            String moveDirection = commands[0];
            int distance = Integer.parseInt(commands[1]);

            Position direction = directionMapper.get(moveDirection);

            Position tmp = new Position(cur.x, cur.y);
            boolean isUpdated = true;
            for (int i=0; i<distance; i++) {
                tmp = tmp.move(direction);
                if (tmp.x<0 || tmp.x>=park.length || tmp.y<0 || tmp.y>=park[i].length()) {
                    isUpdated = false;
                    break;
                }
                if (park[tmp.x].charAt(tmp.y) == 'X') {
                    isUpdated = false;
                    break;
                }
            }

            if (isUpdated) {
                cur = tmp;
            }
        }

        int[] answer = {cur.x, cur.y};

        return answer;
    }

    public Position initStart(String[] park) {
        for (int i=0; i<park.length; i++) {
            for (int j=0; j<park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new Position(i, j);
                }
            }
        }
        return new Position(0,0);
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position move(Position other) {
            return new Position(this.x + other.x, this.y + other.y);
        }
    }
}