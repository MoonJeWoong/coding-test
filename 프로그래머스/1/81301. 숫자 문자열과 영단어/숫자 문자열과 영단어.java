import java.util.*;

class Solution {
    
    // 영단어 별 숫자 매핑 역할 맵 자료구조 정의 후 초기화
    private static final Map<String, Integer> mapper = new HashMap<>();
    
    static {
        mapper.put("zero", 0);
        mapper.put("one", 1);
        mapper.put("two", 2);
        mapper.put("three", 3);
        mapper.put("four", 4);
        mapper.put("five", 5);
        mapper.put("six", 6);
        mapper.put("seven", 7);
        mapper.put("eight", 8);
        mapper.put("nine", 9);
    }
    
    public int solution(String s) {
        
        // while 문 돌면서 idx 참조
            // 해당 idx 에 위치하는 char가 숫자인지 아닌지 파악
            // 숫자라면 answer에 append
            // 숫자가 아니라면 맵 자료구조의 key 값들을 순회하며 indexOf를 찍어봤을 때 현재 인덱스와 동일한 key 값을 찾는다.
            // 찾은 key 값에 해당하는 숫자 value를 answer에 append하고 key 문자열의 길이만큼 현재 인덱스를 증가시킨다.
        int cur = 0;
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(cur < s.length()) {
            if (Character.isDigit(arr[cur])) {
                sb.append(arr[cur]);
                cur++;
                continue;
            }
            for (String numKey : mapper.keySet()) {
                if (s.indexOf(numKey, cur) == cur) {
                    sb.append(mapper.get(numKey));
                    cur += numKey.length();
                    break;
                }
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}