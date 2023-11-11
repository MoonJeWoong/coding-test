import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 이름을 키로 가지고 그리움을 값으로 가지는 map 저장
        // photo 배열 길이 만큼의 answer 배열 생성
        // photo 순회하며 값 계산
        
        Map<String, Integer> values = new HashMap<>();
        
        for (int i=0; i<name.length; i++) {
            values.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        for (int i=0; i<answer.length; i++) {
            String[] arr = photo[i];
            int score = 0;
            for (int j=0; j<arr.length; j++) {
                score += values.getOrDefault(arr[j], 0);
            }
            answer[i] = score;
        }
        
        return answer;
    }
}