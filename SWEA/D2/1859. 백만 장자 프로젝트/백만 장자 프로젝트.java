import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution T = new Solution();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt( bf.readLine());
        for(int i=1; i<=test; i++){
            int n = Integer.parseInt(bf.readLine());
            String[] input = bf.readLine().split(" ");
            List<Integer> list= new ArrayList<>();
            for(String x : input){
                list.add(Integer.parseInt(x));
            }
            long answer = 0;
            while(list.size()!=0){
                int maxPrice = list.stream().max(Integer::compareTo).get();
                int idx = list.indexOf(maxPrice);
                for(int x : list.subList(0,idx)){
                    answer+=maxPrice-x;
                }
                list = list.subList(idx+1,list.size());
            }
            System.out.println("#"+i+" "+answer);
        }
    }
}