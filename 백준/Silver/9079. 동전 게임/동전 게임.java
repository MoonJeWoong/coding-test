import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Coordinate>> convertCases = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[][]> cases = new ArrayList<>();
        generateConvertCase();

        for (int iter = 0; iter < n; iter++) {
            int[][] inputCase = new int[3][3];
            for (int iter2 = 0; iter2 < 3; iter2++) {
                inputCase[iter2] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(value -> convertToInt(value))
                        .toArray();
            }
            cases.add(inputCase);
        }

        for (int[][] testCase : cases) {
            System.out.println(bfs(testCase));
        }
    }

    public static int convertToInt(String value) {
        if (value.equals("H")) {
            return 1;
        }
        return 0;
    }

    private static int bfs(int[][] testCase) {
        // testCase에 대해서 모든 경우의 수를 따진다.
        boolean[] visited = new boolean[512];

        Deque<int[][]> queue = new LinkedList<>();
        queue.offer(testCase);
        int count = 0;
        boolean isAnswered = false;
        visited[convertToIndex(testCase)] = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int iter = 0; iter < queueSize; iter++) {
                int[][] tempCase = queue.poll();
                int convertedIndex = convertToIndex(tempCase);
                if (convertedIndex == 0 || convertedIndex == 511) {
                    isAnswered = true;
                    break;
                }

                // 케이스 변환 로직 구현
                for (List<Coordinate> convertCase : convertCases) {
                    int[][] nextCase = copyNewCase(tempCase);
                    for (Coordinate coordinate : convertCase) {
                        nextCase[coordinate.row][coordinate.column] = Math.abs(nextCase[coordinate.row][coordinate.column] - 1);
                    }
                    if (!visited[convertToIndex(nextCase)]) {
                        visited[convertToIndex(nextCase)] = true;
                        queue.offer(nextCase);
                    }
                }
            }
            if (isAnswered) {
                return count;
            }
            count++;
        }
        return -1;
    }

    private static int[][] copyNewCase(int[][] inputCase) {
        int[][] newCase = new int[3][3];
        newCase[0] = Arrays.copyOf(inputCase[0], 3);
        newCase[1] = Arrays.copyOf(inputCase[1], 3);
        newCase[2] = Arrays.copyOf(inputCase[2], 3);
        return newCase;
    }

    private static List<List<Coordinate>> generateConvertCase() {

        // 행변환
        for (int index = 0; index < 3; index++) {
            List<Coordinate> convertCase = new ArrayList<>();
            convertCase.add(new Coordinate(index, 0));
            convertCase.add(new Coordinate(index, 1));
            convertCase.add(new Coordinate(index, 2));
            convertCases.add(convertCase);
        }

        // 열변환
        for (int index = 0; index < 3; index++) {
            List<Coordinate> convertCase = new ArrayList<>();
            convertCase.add(new Coordinate(0, index));
            convertCase.add(new Coordinate(1, index));
            convertCase.add(new Coordinate(2, index));
            convertCases.add(convertCase);
        }

        // 대각선 변환
        List<Coordinate> convertDiagonalCase1 = new ArrayList<>();
        convertDiagonalCase1.add(new Coordinate(0,0));
        convertDiagonalCase1.add(new Coordinate(1,1));
        convertDiagonalCase1.add(new Coordinate(2,2));

        List<Coordinate> convertDiagonalCase2 = new ArrayList<>();
        convertDiagonalCase2.add(new Coordinate(0,2));
        convertDiagonalCase2.add(new Coordinate(1,1));
        convertDiagonalCase2.add(new Coordinate(2,0));

        convertCases.add(convertDiagonalCase1);
        convertCases.add(convertDiagonalCase2);

        return convertCases;
    }

    private static int convertToIndex(int[][] testCase) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < 3; index++) {
            for (int value : testCase[index]) {
                sb.append(value);
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}

class Coordinate {
    int row;
    int column;

    public Coordinate (int row, int column) {
        this.row = row;
        this.column = column;
    }
}