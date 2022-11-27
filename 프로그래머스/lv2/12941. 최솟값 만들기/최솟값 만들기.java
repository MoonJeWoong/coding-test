import java.util.*;
import java.util.stream.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        PriorityQueue<Integer> naturalOrder = new PriorityQueue<>();
        PriorityQueue<Integer> reverseOrder = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<A.length; i++){
            naturalOrder.offer(A[i]);
            reverseOrder.offer(B[i]);
        }
        for(int i=0; i<A.length; i++){
            answer += naturalOrder.poll() * reverseOrder.poll();
        }
        
        return answer;
    }
}