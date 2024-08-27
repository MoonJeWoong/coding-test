import java.util.*;

class Solution {
    
    private static final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    
    public int solution(int k, int m, int[] score) {
        for (int num : score) {
            pq.offer(num);
        }
        
        int answer = 0;
        while (pq.size() >= m) {
            int cost = Integer.MAX_VALUE;
            for (int idx = 0; idx < m; idx++) {
                cost = Math.min(cost, pq.poll());
            }
            answer += cost * m;
        }
        
        return answer;
    }
}