import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stk = new Stack<>();
        int answer = 0;
        for(int x : moves){
            int pos = x-1;
            for(int i=0; i<board.length; i++){
                if(board[i][pos]!=0){
                    if(!stk.isEmpty() && stk.peek()==board[i][pos]){
                        stk.pop();
                        answer+=2;
                    }
                    else stk.push(board[i][pos]);
                    board[i][pos] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}