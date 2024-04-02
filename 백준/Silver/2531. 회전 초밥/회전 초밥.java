
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0], d = inputs[1], k = inputs[2], c = inputs[3];
        int[] belt = new int[n];

        for (int idx = 0; idx < n; idx++) {
            belt[idx] = Integer.parseInt(br.readLine());
        }

        int lt = 0, rt = lt + k - 1;
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        // 0부터 k번째 접시의 초밥을 추가
        for(int idx = lt; idx <= rt; idx++) {
            count.put(belt[idx], count.getOrDefault(belt[idx], 0) + 1);
            set.add(belt[idx]);
        }

        int answer = set.size();
        if (!set.contains(c)) {
            answer++;
        }
        int sushiTypes;

        // 현재 lt, rt 작업 이후 lt, rt를 변화시켜줘야 한다.
        for (; lt < n; lt++) {
            // lt 제거
            count.put(belt[lt], count.get(belt[lt]) - 1);
            if (count.get(belt[lt]) == 0) {
                count.remove(belt[lt]);
                set.remove(belt[lt]);
            }

            // rt 추가
            rt = (rt + 1) % n;
            count.put(belt[rt], count.getOrDefault(belt[rt], 0) + 1);
            set.add(belt[rt]);

            sushiTypes = set.size();
            if (!set.contains(c)) {
                sushiTypes++;
            }
            answer = Math.max(answer, sushiTypes);
        }

        System.out.println(answer);
    }
}
