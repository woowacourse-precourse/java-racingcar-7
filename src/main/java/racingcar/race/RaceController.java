package racingcar.race;

import racingcar.racer.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceController {

    public List<Car> moveAll(List<Car> cars) {
        for (Car car : cars) {
            car.tryMove();
        }
        return cars;
    }

    public List<String> findWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        List<Integer> distanceList = new ArrayList<>();
        for (Car car : cars) {
            distanceList.add(car.getDistance().length());
        }
        Integer maxDistance = Collections.max(distanceList);
        for (Car car : cars) {
            if (car.getDistance().length() >= maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
