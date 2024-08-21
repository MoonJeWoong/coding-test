import java.util.*;

class Solution {
    
    private static final Map<Character, Integer> counter = new HashMap<>();
    
    public int[] solution(String[] keymap, String[] targets) {
        
        for (String str : keymap) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                counter.put(chars[i], Math.min(i + 1, counter.getOrDefault(chars[i], Integer.MAX_VALUE)));
            }
        }
        
        int[] answer = new int[targets.length];
        for (int idx = 0; idx < targets.length; idx++) {
            String target = targets[idx];
            int count = 0;
            for (char c : target.toCharArray()) {
                if (!counter.containsKey(c)) {
                    count = -1;
                    break;
                }
                count += counter.get(c);
            }
            answer[idx] = count;
        }
        
        return answer;
    }
}