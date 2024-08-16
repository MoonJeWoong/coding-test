import java.util.*;
import java.util.stream.*;

class Solution {
    
    private static final Map<Character, Character> closeCase = new HashMap<>();
    
    static {
        closeCase.put(')', '(');
        closeCase.put('}', '{');
        closeCase.put(']', '[');
    }
    
    public int solution(String s) {
        int answer = 0;
        char[] cases = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(new String(cases, i, s.length() - i));
            sb.append(new String(cases, 0, i));
            if (checkString(sb.toString())) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean checkString(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (closeCase.containsKey(c)) {
                if (queue.size() == 0) {
                    return false;
                }
                char openCase = queue.pollLast();
                if (closeCase.get(c) != openCase) {
                    return false;
                }
            } else {
                queue.offerLast(c);
            }
        }
        
        if (queue.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}