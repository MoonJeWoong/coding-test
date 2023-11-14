import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playersMap = initPlayersMap(players);
        
        for (String calling : callings) {
            int idx = playersMap.get(calling);
            swap(players, playersMap, idx);
        }
        return players;
    }
    
    public Map<String, Integer> initPlayersMap(String[] players) {
        Map<String, Integer> playersMap = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
            playersMap.put(players[i], i);
        }
        return playersMap;
    }
    
    // public int findIndex(List<String> playerList, String calling) {
    //     for (int i=0; i<playerList.size(); i++) {
    //         if (players[i].equals(calling)) {
    //             return i;
    //         }
    //     }
    //     return 0;
    // }
    
    public void swap(String[] players, Map<String, Integer> playersMap, int callingIndex) {
        String outRunner = players[callingIndex];
        players[callingIndex] = players[callingIndex-1];
        players[callingIndex-1] = outRunner;
        
        playersMap.put(outRunner, callingIndex-1);
        playersMap.put(players[callingIndex], callingIndex);
    }
}