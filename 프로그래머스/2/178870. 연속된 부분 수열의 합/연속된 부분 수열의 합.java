import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int lt = 0, rt = 0;
        int tempLt = 0, tempRt = Integer.MAX_VALUE;
        int sum = sequence[0];
        
        // lt가 rt보다 작거나 같은 동안 && sum이 
        while (lt <= rt && rt < sequence.length) {
            if (rt < sequence.length - 1) {
                if (sum > k) {
                sum -= sequence[lt++];
                continue;
                }
                
                if (sum < k) {
                    sum += sequence[++rt];
                } else if (sum == k) {
                    if (tempRt - tempLt > rt - lt) {
                        tempRt = rt;
                        tempLt = lt;
                    }
                    sum += sequence[++rt];
                }
            } else if (rt == sequence.length - 1) {
                if (sum > k) {
                sum -= sequence[lt++];
                continue;
                }
                
                if (sum < k) {
                    break;
                } else if (sum == k) {
                    if (tempRt - tempLt > rt - lt) {
                        tempRt = rt;
                        tempLt = lt;
                    }
                    break;
                }
            }
        }
        
        int[] answer = {tempLt, tempRt};
        return answer;
    }
}