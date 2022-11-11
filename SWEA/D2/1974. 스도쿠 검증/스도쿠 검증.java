import java.util.Scanner;

public class Solution {
    static int[][] mat;

    public boolean rowCheck(){
        int[] check;
        for(int i=0; i<9; i++){
            check = new int[10];
            for(int j=0; j<9; j++){
                if(check[mat[i][j]]!=0){
                    return false;
                }
                check[mat[i][j]]=1;
            }
        }
        return true;
    }

    public boolean columnCheck(){
        int[] check;
        for(int i=0; i<9; i++){
            check = new int[10];
            for(int j=0; j<9; j++){
                if(check[mat[j][i]]!=0){
                    return false;
                }
                check[mat[j][i]]=1;
            }
        }
        return true;
    }

    public boolean threeSizeMatCheck(){
        int[] check;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                check = new int[10];
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        if(check[mat[i*3+k][j*3+l]]!=0){
                            return false;
                        }
                        check[mat[i*3+k][j*3+l]]=1;
                    }
                }
            }
        }
        return true;
    }

    public int solution(){
        if(!rowCheck() || !columnCheck() || !threeSizeMatCheck()){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        for(int i=0; i<testNum; i++){
            mat = new int[9][9];
            for(int j=0; j<9; j++){
                for(int k=0; k<9; k++){
                    mat[j][k] = sc.nextInt();
                }
            }
            System.out.println("#"+(i+1)+" "+T.solution());
        }
    }
}