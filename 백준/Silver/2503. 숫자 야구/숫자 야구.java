import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int checkStrikes(String num1, String num2) {
        int count = 0;
        for (int index = 0; index < 3; index++) {
            if (num1.charAt(index) == num2.charAt(index)) {
                count++;
            }
        }
        return count;
    }

    private static int checkBalls(String num1, String num2) {
        int count = 0;
        for (int index=0; index<3; index++) {
            if (num1.charAt(index) != num2.charAt(index) &&
            num2.contains(String.valueOf(num1.charAt(index)))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Question> questions = new ArrayList<>();
        for (int iter=0; iter<n; iter++) {
            String[] inputs = br.readLine().split(" ");
            questions.add(new Question(inputs[0], Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])));
        }

        int answer = 0;

        for (int first=1; first <= 9; first++) {
            for (int second=1; second <= 9; second++) {
                if (first == second) {
                    continue;
                }
                for (int third=1; third <= 9; third++) {
                    if (first == third || second == third) {
                        continue;
                    }
                    String checkNum = String.valueOf(first*100 + second*10 + third);
                    boolean candidateFlag = true;
                    // 만들어진 수와 각 questions들을 비교하면서 채점 결과가 맞는지 확인
                    for (Question question : questions) {
                        if (question.strikeCount != checkStrikes(question.num, checkNum) ||
                        question.ballCount != checkBalls(question.num, checkNum)) {
                            candidateFlag = false;
                            break;
                        }
                    }
                    if (candidateFlag) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

class Question {
    String num;
    int strikeCount;
    int ballCount;

    public Question(String num, int strikeCount, int ballCount) {
        this.num = num;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }
}