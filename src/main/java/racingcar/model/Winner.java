package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static List<Car> getWinners(List<Car> cars) {
        int maxLocation = 0;

        for (Car car : cars) {
            if (car.getLocation() > maxLocation) {
                maxLocation = car.getLocation();
            }
        }

        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}