class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx < food.length; idx++) {
            int count = food[idx] / 2;
            for (int iter = 0; iter < count; iter++) {
                sb.append(idx);
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(sb.toString());
        answer.append(0);
        answer.append(sb.reverse().toString());
        return answer.toString();
    }
}