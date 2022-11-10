import java.util.Scanner;

public class Solution {
    static int[][] mat;
    public int smash(int x, int y, int m){
        int tmp = 0;
        for(int i=x; i<x+m; i++){
            for(int j=y; j<y+m; j++){
                tmp += mat[i][j];
            }
        }
        return tmp;
    }

    public int solution(int n, int m){
        int answer = 0;
        for(int i=0; i<n-m+1; i++){
            for(int j=0; j<n-m+1; j++){
                int tmp = smash(i,j,m);
                answer = Math.max(answer, tmp);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i=0; i<testCase; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
           mat = new int[n][n];
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    mat[j][k] = sc.nextInt();
                }
            }
            System.out.println("#"+(i+1)+" "+T.solution(n, m));
        }
    }
}