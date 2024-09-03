import java.util.*;

class Solution {
    private static final Map<String, Integer> exchangeCounter = new HashMap<>();
    private static final Map<String, Integer> giftCounter = new HashMap<>();
    private static final Map<String, Integer> expectCounter = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        for (String name : friends) {
            giftCounter.put(name, 0);
            expectCounter.put(name, 0);
        }
        
        for (String entry : gifts) {
            exchangeCounter.put(entry, exchangeCounter.getOrDefault(entry, 0) + 1);
            String[] splited = entry.split(" ");
            
            giftCounter.put(splited[0], giftCounter.get(splited[0]) + 1);
            giftCounter.put(splited[1], giftCounter.get(splited[1]) - 1);
        }
        
        for (int idx1 = 0; idx1 < friends.length - 1; idx1++) {
            String targetName1 = friends[idx1];
            for (int idx2 = idx1 + 1; idx2 < friends.length; idx2++) {
                String targetName2 = friends[idx2];
                
                if (existingEntry(targetName1, targetName2)) {
                    int targetGiveCount1 = exchangeCounter.getOrDefault(makeEntryKey(targetName1, targetName2), 0);
                    int targetGiveCount2 = exchangeCounter.getOrDefault(makeEntryKey(targetName2, targetName1), 0);
                    if (targetGiveCount1 > targetGiveCount2) {
                        expectCounter.put(targetName1, expectCounter.get(targetName1) + 1);
                        continue;
                    }
                    if (targetGiveCount1 < targetGiveCount2) {
                        expectCounter.put(targetName2, expectCounter.get(targetName2) + 1);
                        continue;
                    }
                }
                
                int targetCount1 = giftCounter.get(friends[idx1]);
                int targetCount2 = giftCounter.get(friends[idx2]);
                
                if (targetCount1 > targetCount2) {
                    expectCounter.put(targetName1, expectCounter.get(targetName1) + 1);
                    continue;
                }
                if (targetCount1 < targetCount2) {
                    expectCounter.put(targetName2, expectCounter.get(targetName2) + 1);
                    continue;
                }
            }
        }
        
        int answer = expectCounter.values().stream()
            .mapToInt(Integer::intValue)
            .max()
            .getAsInt();
        return answer;
    }
    
    private String makeEntryKey(String name1, String name2) {
        return name1 + " " + name2;
    }
    
    private boolean existingEntry(String name1, String name2) {
        String candidate1 = name1 + " " + name2;
        String candidate2 = name2 + " " + name1;
        
        return exchangeCounter.containsKey(candidate1) || exchangeCounter.containsKey(candidate2);
    }
}