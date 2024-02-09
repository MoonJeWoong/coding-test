import java.io.*;
import java.util.*;

public class Main {

    private static String[][] originBoard;
    private static String[] whiteBlackLine = {"W", "B", "W", "B", "W", "B", "W", "B"};
    private static String[] blackWhiteLine = {"B", "W", "B", "W", "B", "W", "B", "W"};
    private static int answer;

    private static void initChessBoard(String[][] chessboard, int startRow, int startCol) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                chessboard[row][col] = originBoard[startRow + row][startCol + col];
            }
        }
    }

    private static int countUpdateSquare(String[][] chessBoard) {
        int whiteCaseCount = 0;
        int blackCaseCount = 0;

        // 최상단 좌측 흰색, 최상단 좌측 검은색인 케이스 분리해서 계산
        for (int row = 0; row < 8; row++) {
            if (row % 2 == 0) {
                whiteCaseCount += countDifferentSquares(chessBoard[row], whiteBlackLine);
                blackCaseCount += countDifferentSquares(chessBoard[row], blackWhiteLine);
            }
            else {
                whiteCaseCount += countDifferentSquares(chessBoard[row], blackWhiteLine);
                blackCaseCount += countDifferentSquares(chessBoard[row], whiteBlackLine);
            }
        }

        return Math.min(whiteCaseCount, blackCaseCount);
    }

    private static int countDifferentSquares(String[] boardLine, String[] compareLine) {
        int count = 0;
        for (int index = 0; index < 8; index++) {
            if (!boardLine[index].equals(compareLine[index])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int boardRow = Integer.parseInt(inputs[0]);
        int boardColumn = Integer.parseInt(inputs[1]);

        originBoard = new String[boardRow][boardColumn];
        answer = Integer.MAX_VALUE;

        for (int iter = 0; iter < originBoard.length; iter++) {
            originBoard[iter] = br.readLine().split("");
        }

        for (int row = 0; row < boardRow - 7; row++) {
            for (int col = 0; col < boardColumn - 7; col++) {
                String[][] chessBoard = new String[8][8];
                initChessBoard(chessBoard, row, col);
                answer = Math.min(answer, countUpdateSquare(chessBoard));
            }
        }

        System.out.println(answer);
    }
}