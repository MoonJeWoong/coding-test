import java.util.*;
import java.util.stream.*;

class Solution {
    private static Map<String, Integer> results = new HashMap<>();
    // private static Map<Set<String>, Integer> classMapper = new HashMap<>();
    private static List<List<String>> defaultClasses = List.of(
        List.of("R", "T"),
        List.of("C", "F"),
        List.of("J", "M"),
        List.of("A", "N")
    );
    
    static {
        int idx = 0;
        for (List<String> defaultClass : defaultClasses) {
            results.put(defaultClass.get(0), 0);
            results.put(defaultClass.get(1), 0);
            
            // Set<String> tmpSet = new HashSet<>(defaultClass);
            // classMapper.put(tmpSet, idx++);
        }
    }
    
    public String solution(String[] survey, int[] choices) {
        
        for (int iter=0; iter<survey.length; iter++) {
            // Set<String> classKey = Arrays.stream(survey[iter].split(""))
            //     .collect(Collectors.toSet());
            
            // 설문조사 선택지 별 점수 취합
            int classIndex = getClassIndex(choices[iter]);
            if (classIndex != -1) {
                String classKey = survey[iter].substring(classIndex, classIndex + 1);
                results.put(classKey, results.get(classKey) + calculateScore(choices[iter]));
            }
        }
        
        // 선택지 분류 별로 더 높은 분류 기준 선택하기
        StringBuilder answer = new StringBuilder();
        for (List<String> defaultClass : defaultClasses) {
            int firstClassScore = results.get(defaultClass.get(0));
            int secondClassScore = results.get(defaultClass.get(1));
            
            if (firstClassScore >= secondClassScore) {
                answer.append(defaultClass.get(0));
            } else {
                answer.append(defaultClass.get(1));
            }
        }
        
        return answer.toString();
    }
    
    public int getClassIndex(int choice) {
        if (choice < 4) {
            return 0;
        } else if (choice > 4) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public int calculateScore(int choice) {
        return Math.abs(choice - 4);
    }
}