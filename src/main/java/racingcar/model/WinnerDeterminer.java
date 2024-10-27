package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class WinnerDeterminer {
    private List<Car> cars;

    public WinnerDeterminer(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> determineWinners() {
        int maxDistance = getMaxDistance();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }
}
