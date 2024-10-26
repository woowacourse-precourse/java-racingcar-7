package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGameRoundResult {
    private final List<Car> cars;

    public RacingGameRoundResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> calculateWinners() {
        List<String> winners = new ArrayList<>();
        int maxLocation = findMaxLocation();

        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int findMaxLocation() {
        int maxLocation = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxLocation = Math.max(maxLocation, car.getLocation());
        }
        return maxLocation;
    }
}
