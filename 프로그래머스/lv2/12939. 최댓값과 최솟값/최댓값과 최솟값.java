import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] arr = Arrays.asList(s.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int maxNum = Arrays.stream(arr).max().getAsInt();
        int minNum = Arrays.stream(arr).min().getAsInt();
        String ans = "";
        ans += minNum + " " + maxNum;
        return ans;
    }
}