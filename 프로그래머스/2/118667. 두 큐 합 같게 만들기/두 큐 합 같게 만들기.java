import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        long queue1Sum = 0;
        long queue2Sum = 0;
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        long maxNum = Long.MIN_VALUE;
        for (int i=0; i<queue1.length; i++) {
            sum += queue1[i] + queue2[i];
            q1.offerLast(queue1[i]);
            queue1Sum += queue1[i];
            q2.offerLast(queue2[i]);
            queue2Sum += queue2[i];
            maxNum = Math.max(maxNum, Math.max(queue1[i], queue2[i]));
        }
        if (maxNum > sum / 2 || sum % 2 == 1) {
            return -1;
        }
        
        int totalCounter = (queue1.length + queue2.length) * 2;
        for (int counter=0; counter < totalCounter; counter++) {
            if (queue1Sum == queue2Sum) {
                return counter;
            }
            if (queue1Sum > queue2Sum) {
                int tmp = q1.pollFirst();
                queue1Sum -= tmp;
                queue2Sum += tmp;
                q2.offerLast(tmp);
                continue;
            } 
            if (queue1Sum < queue2Sum) {
                int tmp = q2.pollFirst();
                queue1Sum += tmp;
                queue2Sum -= tmp;
                q1.offerLast(tmp);
                continue;
            }
        }
        return -1;
    }
}