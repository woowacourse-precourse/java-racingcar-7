package racingcar.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.domain.Car;

public class OutputWriter {

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printFinalWinner(List<Car> cars) {

        Map<String, Integer> distanceScores = new HashMap<>();
        List<String> maxKeys = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;

        for (Car car : cars) {
            distanceScores.put(car.getName(), car.getDistance());
        }

        for (Entry<String, Integer> entry : distanceScores.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKeys.clear();
                maxKeys.add(entry.getKey());
            } else if (entry.getValue() == maxValue) {
                maxKeys.add((entry.getKey()));
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", maxKeys));

    }
}
