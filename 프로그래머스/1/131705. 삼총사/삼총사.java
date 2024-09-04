import java.util.*;

class Solution {
    private static int answer = 0;
    
    public int solution(int[] number) {
        dfs(number, 0, new ArrayList<>());
        return answer;
    }
    
    private void dfs(int[] number, int selected, List<Integer> students) {
        if (students.size() == 3) {
            int sumVal = students.stream()
                .mapToInt(Integer::intValue)
                .sum();
            if (sumVal == 0) {
                answer++;
            }
            return;
        }
        
        for (int idx = selected; idx < number.length; idx++) {
            List<Integer> selectedStudents = new ArrayList<>(students);
            selectedStudents.add(number[idx]);
            dfs(number, idx + 1, selectedStudents);
        }
    }
}