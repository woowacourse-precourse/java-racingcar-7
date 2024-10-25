package racingcar;

import static racingcar.Constant.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputUtils {

    public static void printPosition(List<Car> carList){
        for(Car car: carList){
            System.out.println(car.getName() + " : " + IntStream.range(0,car.getPosition())
                    .mapToObj(i -> "-")
                    .collect(Collectors.joining()));
        }
        System.out.println();
    }

    private static ArrayList<String> findWinner(List<Car> carList){
        HashMap<Integer, ArrayList<String>> ranking = new HashMap<>();
        int maxMoving = -1;

        for (Car car:carList){
            int carPosition = car.getPosition();
            maxMoving = Math.max(maxMoving, carPosition);

            if(!ranking.containsKey(carPosition)){
                ranking.put(carPosition, new ArrayList<>());
            }
            ranking.get(carPosition).add(car.getName());
        }
        return ranking.get(maxMoving);
    }

    public static void printEnding(List<Car> carList) {
        ArrayList<String> winnerList = findWinner(carList);
        String winner = "";
        if (winnerList.size() > 1) {
            winner = String.join(", ", winnerList);
        }
        if (winnerList.size() == 1){
            winner = winnerList.getFirst();
        }
        System.out.println(PRINT_WINNER + winner);
    }
}
