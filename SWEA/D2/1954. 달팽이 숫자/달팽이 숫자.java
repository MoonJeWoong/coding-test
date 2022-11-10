import java.util.Scanner;

class Pos {
    public int x;
    public int y;
    public int value=1;
    public int direction=0;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int num, dest;

    public void dfs(Pos pos, int[][] mat){
        mat[pos.x][pos.y] = pos.value;
        if(pos.value==dest){
            return;
        }
        if(pos.x+dx[pos.direction]<0 || pos.x+dx[pos.direction]>=num || pos.y+dy[pos.direction]<0 || pos.y+dy[pos.direction]>=num || mat[pos.x+dx[pos.direction]][pos.y+dy[pos.direction]]!=0){
            pos.direction = (pos.direction+1)%4;
        }
        pos.x+=dx[pos.direction];
        pos.y+=dy[pos.direction];
        pos.value+=1;
        dfs(pos, mat);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i=0; i<testCase; i++){
            num = sc.nextInt();
            dest = num*num;
            int[][] mat = new int[num][num];
            Pos pos = new Pos(0,0);
            T.dfs(pos,mat);
            System.out.printf("#%d\n",i+1);
            for(int j=0; j<num; j++){
                for(int k=0; k<num; k++){
                    System.out.printf("%d ",mat[j][k]);
                }
                System.out.println();
            }
        }
    }
}
