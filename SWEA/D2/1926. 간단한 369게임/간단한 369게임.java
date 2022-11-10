import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            int tmp = i;
            int clap=0;
            while(tmp>0){
                int digit = tmp%10;
                if(digit==3 || digit==6 || digit==9){
                    clap++;
                } else{
                    sb.append(digit);
                }
                tmp/=10;
            }
            if(clap>0){
                sb.setLength(0);
                while(clap>0){
                    sb.append("-");
                    clap--;
                }
            }
            System.out.printf("%s ",sb.reverse());
        }
    }
}