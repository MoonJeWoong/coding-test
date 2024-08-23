import java.util.*;

class Solution {
    public int solution(String s) {
        List<String> answers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        Character firstChar = null;
        int firstCount = 0;
        int secondCount = 0;
        
        for (char c : s.toCharArray()) {
            if (firstChar == null) {
                firstChar = c;
            }
            
            if (firstChar == c) {
                firstCount++;
            } else {
                secondCount++;
            }
            
            sb.append(String.valueOf(c));
            if (firstCount == secondCount) {
                answers.add(sb.toString());
                sb = new StringBuilder();
                firstChar = null;
                firstCount = 0;
                secondCount = 0;
            }
        }
        
        if (sb.length() != 0) {
            answers.add(sb.toString());
        }
        
        return answers.size();
    }
}