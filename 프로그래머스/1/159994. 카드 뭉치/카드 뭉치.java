import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        // cards1, cards2 배열의 요소 값들을 순서대로 stack에 담는다.
        // goal의 요소 값들을 순회하면서 두 stack의 top 요소 값들 중 일치하는 게 있는지 확인한다.
        // 있다면 해당 요소를 pop 시키고 넘어간다.
        // 없다면 No를 return 한다.
        
        String answer = "Yes";
        
        Deque<String> cardQ1 = new LinkedList<>();
        for (String card : cards1) {
            cardQ1.offer(card);
        }
        
        Deque<String> cardQ2 = new LinkedList<>();
        for (String card : cards2) {
            cardQ2.offer(card);
        }
        
        for (String word : goal) {
            if (Objects.nonNull(cardQ1.peek()) && cardQ1.peek().equals(word)) {
                cardQ1.poll();
                continue;
            }
            if (Objects.nonNull(cardQ2.peek())  && cardQ2.peek().equals(word)) {
                cardQ2.poll();
                continue;
            }
            answer = "No";
            break;
        }
        
        return answer;
    }
}