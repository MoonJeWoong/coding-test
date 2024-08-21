class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int maxTime = attacks[attacks.length - 1][0];
        int attackerTurn = 0;
        int currentHealth = health;
        int healingCount = 0;
        
        for (int time = 1; time <= maxTime; time++) {
            if (currentHealth <= 0) {
                return -1;
            }
            
            // 몬스터 공격 턴
            if (attacks[attackerTurn][0] == time) {
                currentHealth -= attacks[attackerTurn][1];
                healingCount = 0;
                attackerTurn++;
                continue;
            }
            
            currentHealth += bandage[1];
            healingCount++;
            if (healingCount == bandage[0]) {
                currentHealth += bandage[2];
                healingCount = 0;
            }
            if (currentHealth > health) {
                currentHealth = health;
            }
            
        }
        
        if (currentHealth <= 0) {
                return -1;
        }
        return currentHealth;
    }
}