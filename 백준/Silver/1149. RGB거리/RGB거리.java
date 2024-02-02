import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<House> houses = new ArrayList<>();
        int[] redHouses = new int[n+1];
        int[] greenHouses = new int[n+1];
        int[] blueHouses = new int[n+1];

        for (int index = 1; index < n+1; index++) {
            String[] inputs = br.readLine().split(" ");
            houses.add(
                    new House(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]),
                            Integer.parseInt(inputs[2]))
            );
        }

        House firstHouse = houses.get(0);
        redHouses[1] = firstHouse.redCost;
        greenHouses[1] = firstHouse.greenCost;
        blueHouses[1] = firstHouse.blueCost;

        for (int index = 2; index < n+1; index++) {
            House target = houses.get(index-1);
            redHouses[index] = Math.min(greenHouses[index-1], blueHouses[index-1]) + target.redCost;
            greenHouses[index] = Math.min(redHouses[index-1], blueHouses[index-1]) + target.greenCost;
            blueHouses[index] = Math.min(redHouses[index-1], greenHouses[index-1]) + target.blueCost;
        }

        Integer answer = List.of(redHouses[n], greenHouses[n], blueHouses[n]).stream()
                .min(Comparator.naturalOrder())
                .get();

        System.out.println(answer);
    }
}

class House {
    int redCost;
    int greenCost;
    int blueCost;

    public House(int redCost, int greenCost, int blueCost) {
        this.redCost = redCost;
        this.blueCost = blueCost;
        this.greenCost = greenCost;
    }
}