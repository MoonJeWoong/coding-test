import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자 별로 찍은 답 리스트 생성
        int[] student1Pattern = new int[] {1, 2, 3, 4, 5};
        int[] student2Pattern = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3Pattern = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] ansCnts = new int[] {0, 0, 0};

        for (int i=0; i<answers.length; i++) {
            if (student1Pattern[i % student1Pattern.length] == answers[i]) {
                ansCnts[0] = ansCnts[0]+1;
            }
            if (student2Pattern[i % student2Pattern.length] == answers[i]) {
                ansCnts[1] = ansCnts[1]+1;
            }
            if (student3Pattern[i % student3Pattern.length] == answers[i]) {
                ansCnts[2] = ansCnts[2]+1;
            }
        }

        // 문제를 가장 많이 맞춘 수포자를 반환
        int[] cloned = ansCnts.clone();
        Arrays.sort(cloned);
        int maxCnt = cloned[cloned.length-1];        

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<ansCnts.length; i++) {
            if (ansCnts[i] == maxCnt) {
                ans.add(i+1);
            }
        }

        int[] arr = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}