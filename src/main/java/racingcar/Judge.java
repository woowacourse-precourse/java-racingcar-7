package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    List<Car> winners = new ArrayList<>();

    public List<Car> judge(Car[] cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            int distance = car.getDistance().length();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        for (Car car : cars) {
            if (car.getDistance().length() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }
}
