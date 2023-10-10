import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pValue = Long.parseLong(p);
        
        for (int i=0; i<=t.length()-p.length(); i++) {
            long subNum = Long.parseLong(t.substring(i, i+p.length()));
            if (subNum <= pValue) {
                answer++;
            }
        }
        return answer;
    }
}