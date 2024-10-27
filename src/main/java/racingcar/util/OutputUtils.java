package racingcar.util;

import static racingcar.util.Constant.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputUtils {
    public static void printPosition(List<Car> carList){
        for(Car car: carList){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static ArrayList<String> findWinner(List<Car> carList){
        HashMap<Integer, ArrayList<String>> ranking = carList.stream()
                .collect(Collectors.groupingBy(
                        Car::getPosition,
                        HashMap::new,
                        Collectors.mapping(Car::getName,Collectors.toCollection(ArrayList::new))));
        int maxMoving = ranking.keySet().stream().max(Integer::compareTo).orElse(-1);
        return ranking.get(maxMoving);
    }

    public static void printEnding(List<Car> carList) {
        List<String> winnerList = findWinner(carList);
        String winner = String.join(", ", winnerList);
        System.out.println(PRINT_WINNER + winner);
    }
}
