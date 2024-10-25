package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static List<Car> findWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return findCarsWithMaxPosition(cars, maxPosition);
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private static List<Car> findCarsWithMaxPosition(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
