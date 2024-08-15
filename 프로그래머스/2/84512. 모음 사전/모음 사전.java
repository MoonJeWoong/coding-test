import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    
    private static List<String> dictionary = new ArrayList<>();
    private static List<Character> alphabets = List.of('A', 'E', 'I', 'O', 'U'); 
    
    void dfs(String word) {
        if (word.length() == 5) {
            return;
        }
        
        for (char c : alphabets) {
            String nextWord = word + String.valueOf(c);
            dictionary.add(nextWord);
            dfs(nextWord);
        }
    }
    
    public int solution(String word) {
        dfs("");
        return dictionary.indexOf(word) + 1;
    }
}