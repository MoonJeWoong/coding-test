import java.util.*;

class Solution {
    private static final int[] discountRates = {10, 20, 30, 40};
    private static List<int[]> discountCases = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 이모티콘 할인율 조합 별 가격 총합을 구해서 캐싱
        // 사용자 별 구매 금액 계산
        // 서비스 가입자 수 계산 + 이모티콘 판매액 감소
        
        initDiscountCases(0, new int[emoticons.length], emoticons.length);
        
        int[] answer = new int[2];
        
        for (int[] discountCase : discountCases) {
            int[] discountPrices = calculatePrices(discountCase, emoticons);
            int totalAmount = 0;
            int totalServiceCount = 0;
            
            for (int[] user : users) {
                int amount = 0;
                for (int idx = 0; idx < discountCase.length; idx++) {
                    if (discountCase[idx] >= user[0]) {
                        amount += discountPrices[idx];
                    }
                }
                if (amount >= user[1]) {
                    amount = 0;
                    totalServiceCount++;
                }
                totalAmount += amount;
            }
            if (answer[0] < totalServiceCount) {
                answer[0] = totalServiceCount;
                answer[1] = totalAmount;
            } else if (answer[0] == totalServiceCount) {
                answer[1] = Math.max(answer[1], totalAmount);
            }
        }
        
        return answer;
    }
    
    private void initDiscountCases(int idx, int[] discountCase, int maxLength) {
        if (idx == maxLength) {
            discountCases.add(Arrays.copyOf(discountCase, maxLength));
            return;
        }
        
        for (int iter = 0; iter < discountRates.length; iter++) {
            discountCase[idx] = discountRates[iter];
            initDiscountCases(idx + 1, discountCase, maxLength);
        }
    }
    
    private int[] calculatePrices(int[] discountCase, int[] emoticons) {
        int[] prices = new int[emoticons.length];
        for (int idx = 0; idx < prices.length; idx++) {
            prices[idx] = emoticons[idx] / 100 * (100 - discountCase[idx]);
        }
        return prices;
    }
}