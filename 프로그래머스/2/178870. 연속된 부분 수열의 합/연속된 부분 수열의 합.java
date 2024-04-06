import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int lt = 0, rt = 0;
        int sum = sequence[rt];
        int seqLt = 0, seqRt = sequence.length - 1;
        
        while (rt < sequence.length) {
            if (sum > k) {
                sum -= sequence[lt++];
            } else if (sum < k) {
                if (++rt < sequence.length) {
                    sum += sequence[rt];
                }
            } else {
                if (seqRt - seqLt > rt - lt) {
                    seqRt = rt;
                    seqLt = lt;
                }
                sum -= sequence[lt++];
            }
        }
        
        int[] answer = {seqLt, seqRt};
        return answer;
    }
}