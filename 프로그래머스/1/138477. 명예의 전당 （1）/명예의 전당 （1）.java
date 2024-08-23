import java.util.*;

class Solution {
    
    private static final Queue<Integer> honors = new PriorityQueue<>();
    
    public int[] solution(int k, int[] score) {
        
        List<Integer> answers = new ArrayList<>();
        for (int sc : score) {
            if (honors.size() < k) {
                honors.offer(sc);
            } else if (honors.peek() < sc) {
                honors.poll();
                honors.offer(sc);
            }
            
            answers.add(honors.peek());
        }
        
        return answers.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}