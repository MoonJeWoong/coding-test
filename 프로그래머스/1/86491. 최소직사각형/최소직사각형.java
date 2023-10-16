import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        TreeSet<Integer> biggerNums = new TreeSet<>(Comparator.reverseOrder());
        TreeSet<Integer> smallerNums = new TreeSet<>(Comparator.reverseOrder());
        
        for (int idx=0; idx<sizes.length; idx++) {
            int rowLen = sizes[idx][0];
            int colLen = sizes[idx][1];
            
            if (rowLen > colLen) {
                biggerNums.add(rowLen);
                smallerNums.add(colLen);
                continue;
            }
            biggerNums.add(colLen);
            smallerNums.add(rowLen);
        }
        return biggerNums.first() * smallerNums.first();
    }
}