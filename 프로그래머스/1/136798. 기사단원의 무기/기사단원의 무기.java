import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int num = 1; num <= number; num++) {
            int count = countDivisors(num);
            System.out.println(count);
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        
        return answer;
    }
    
    private int countDivisors(int num) {
        int cnt = 0;
        for (int i = 1; Math.pow(i, 2) <= num; i++) {
            if (num % i == 0) {
                if (Math.pow(i, 2) == num) {
                    cnt++;
                } else {
                    cnt += 2;
                }
            }
        }
        return cnt;
    }
}