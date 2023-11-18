import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, -1);
            }
        }
        
        int[] answer = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            char c = charArray[i];
            if (charMap.get(c) == -1) {
                answer[i] = charMap.get(c);
                charMap.put(c, i);
                continue;
            }
            answer[i] = i - charMap.get(c);
            charMap.put(c, i);
        }
        
        return answer;
    }
}