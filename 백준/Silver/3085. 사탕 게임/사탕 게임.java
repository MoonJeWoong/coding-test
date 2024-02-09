import java.io.*;

public class Main {

    private static int n;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[][] candies = new String[n][n];

        for (int iter = 0; iter < n; iter++) {
            // 사탕 저장
            candies[iter] = br.readLine().split(""); 
        }

        // 인접한 사탕이 다른 경우 탐색
        // 선택된 사탕 위치를 바꾸고 최대 사탕 개수 탐색
        // 원래 위치로 복구하고 다시 탐색 재개

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                //전체 경우를 탐색
                if (row < n-1 && col < n-1) {
                    // 아래, 오른쪽 사탕 검사 가능
                    if (!candies[row][col].equals(candies[row+1][col])) {
                        // 아래쪽 사탕 교환 후 검사, 다시 원상 복구
                        exchangeLowerCandy(candies, row, col);
                        calculateMaximumCandies(candies);
                        exchangeLowerCandy(candies, row, col);
                    }
                    if (!candies[row][col].equals(candies[row][col+1])) {
                        // 오른쪽 사탕 교환 후 검사, 다시 원상 복구
                        exchangeRightCandy(candies, row, col);
                        calculateMaximumCandies(candies);
                        exchangeRightCandy(candies, row, col);
                    }
                }
                else if (row < n-1 && col == n-1) {
                    // 아래쪽 사탕만 검사 가능
                    if (!candies[row][col].equals(candies[row+1][col])) {
                        // 아래쪽 사탕 교환 후 검사, 다시 원상 복구
                        exchangeLowerCandy(candies, row, col);
                        calculateMaximumCandies(candies);
                        exchangeLowerCandy(candies, row, col);
                    }
                }
                else if (row == n-1 && col < n-1) {
                    // 오른쪽 사탕만 검사 가능
                    if (!candies[row][col].equals(candies[row][col+1])) {
                        // 오른쪽 사탕 교환 후 검사, 다시 원상 복구
                        exchangeRightCandy(candies, row, col);
                        calculateMaximumCandies(candies);
                        exchangeRightCandy(candies, row, col);
                    }
                }
                else {
                    // 맨 마지막 자리는 스킵
                }
            }
        }

        System.out.println(answer);

//        for (int i=0; i<n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(candies[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static void exchangeLowerCandy(String[][] candies, int row, int col) {
        String temp = candies[row][col];
        candies[row][col] = candies[row +1][col];
        candies[row +1][col] = temp;
    }

    private static void exchangeRightCandy(String[][] candies, int row, int col) {
        String temp = candies[row][col];
        candies[row][col] = candies[row][col+1];
        candies[row][col+1] = temp;
    }

    private static void calculateMaximumCandies(String[][] candies) {
        for (int index1 = 0; index1 < n; index1++) {
            // row 계산
            String candy = candies[index1][0];
            int count = 1;
            for (int index2 = 1; index2 < n; index2++) {
                if (candy.equals(candies[index1][index2])) {
                    count++;
                } else {
                    candy = candies[index1][index2];
                    count=1;
                }
                answer = Math.max(answer, count);
            }

            // col 계산
            candy = candies[0][index1];
            count = 1;
            for (int index2 = 1; index2 < n; index2++) {
                if (candy.equals(candies[index2][index1])) {
                    count++;
                } else {
                    candy = candies[index2][index1];
                    count=1;
                }
                answer = Math.max(answer, count);
            }
        }
    }
}
