class Solution {
    public int solution(int n, int m, int[] section) {
        
        // n 사이즈 만큼 배열 생성
        // section 표시
        // 배열 순회하면서 표시된 부분부터 m 사이즈 안에 해당하는 부분들 색칠
        // 색칠할 때마다 count++
        // 다 색칠하고 나면 반환
        
        boolean[] checkMap = new boolean[n];
        for (int idx : section) {
            checkMap[idx-1] = true;
        }
        
        int answer = 0;
        for (int i=0; i<n; i++) {
            if (checkMap[i] == true) {
                for (int j=i; j<i+m; j++) {
                    if (j < n) {
                        checkMap[j] = false;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}