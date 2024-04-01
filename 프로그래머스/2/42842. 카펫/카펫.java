class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int tmpRow = 0, tmpColumn = 0, tmpTotalBrown = 0;
        
        for (int piv = 1; piv <= yellow / 2 + 1; piv++) {
            if (yellow % piv == 0) {
                tmpColumn = yellow / piv;
                if (tmpColumn < piv) {
                    break;
                }
                tmpRow = piv;
                tmpTotalBrown = ((tmpRow + 2) + (tmpColumn + 2)) * 2 - 4;
                if (tmpTotalBrown == brown) {
                    break;
                }
            }
        }
        
        answer[0] = tmpColumn + 2;
        answer[1] = tmpRow + 2;
        
        return answer;
    }
}