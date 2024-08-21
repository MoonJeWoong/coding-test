import java.util.*;

class Solution {
    private static final char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
    public String solution(String s, String skip, int index) {
        
        List<String> skippedAlphabets = new ArrayList<>();
        
        for (char c : alphabets) {
            if (skip.indexOf(c) == -1) {
                skippedAlphabets.add(String.valueOf(c));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            String converted = String.valueOf(c);
            int idx = (skippedAlphabets.indexOf(converted) + index) % skippedAlphabets.size();
            sb.append(skippedAlphabets.get(idx));
        }
        
        return sb.toString();
    }
}