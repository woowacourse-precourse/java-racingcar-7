package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final Cars cars;
    private final List<Car> winners;
    private final int maxPosition;

    public Winner(Cars cars) {
        this.cars = cars;
        this.maxPosition = findMaxPosition();
        this.winners = findWinners();
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public int getWinnerPosition() {
        return maxPosition;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
