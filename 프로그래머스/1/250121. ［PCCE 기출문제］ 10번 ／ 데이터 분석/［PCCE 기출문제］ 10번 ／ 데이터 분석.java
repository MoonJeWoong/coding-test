import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int dataIdx = checkDataIdx(ext);
        int sortIdx = checkDataIdx(sort_by);
        
        int[][] filteredData = Arrays.stream(data)
            .filter(item -> item[dataIdx] < val_ext)
            .toArray(int[][]::new);
        
        Arrays.sort(filteredData, (o1, o2) -> o1[sortIdx] - o2[sortIdx]);
        
        return filteredData;
    }
    
    
    private int checkDataIdx(String ext) {
        if (ext.equals("code")) {
            return 0;
        } else if (ext.equals("date")) {
            return 1;
        } else if (ext.equals("maximum")) {
            return 2;
        } else if (ext.equals("remain")) {
            return 3;
        } else {
            return -1;
        }
    }
}