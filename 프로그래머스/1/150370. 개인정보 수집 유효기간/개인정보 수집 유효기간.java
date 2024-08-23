import java.util.*;

class Solution {
    
    private static final Map<String, Integer> parsedTerms = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answers = new ArrayList<>();
        
        for (String term : terms) {
            String[] parsed = term.split(" ");
            parsedTerms.put(parsed[0], Integer.valueOf(parsed[1]));
        }
        
        for (int idx = 0; idx < privacies.length; idx++) {
            String[] parsed = privacies[idx].split(" ");
            int term = parsedTerms.get(parsed[1]);
            
            if (isExpired(today, parsed[0], term)) {
                answers.add(idx + 1);
            }
        }
        
        return answers.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private boolean isExpired(String today, String privacy, int term) {
        int[] convertedToday = Arrays.stream(today.split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int[] convertedPrivacy = Arrays.stream(privacy.split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        convertedPrivacy[1] += term;
        if (convertedPrivacy[1] > 12) {
            convertedPrivacy[0] += convertedPrivacy[1] / 12;
            convertedPrivacy[1] %= 12;
        }
        
        if (convertedPrivacy[2] == 0) {
            convertedPrivacy[2] = 28;
            convertedPrivacy[1] -= 1;
        }
        
        if (convertedPrivacy[1] == 0) {
            convertedPrivacy[1] = 12;
            convertedPrivacy[0] -= 1;
        }
        
        //check
        if (convertedToday[0] > convertedPrivacy[0]) {
            return true;
        }
        
        if (convertedToday[0] == convertedPrivacy[0] 
            && convertedToday[1] > convertedPrivacy[1]) {
            return true;
        }
        
        if (convertedToday[0] == convertedPrivacy[0] 
            && convertedToday[1] == convertedPrivacy[1]
           && convertedToday[2] >= convertedPrivacy[2]) {
            return true;
        }
        
        return false;
        
    }
    
    
}