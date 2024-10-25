package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final Cars cars;
    private final List<Car> winners;
    private final int winnerPosition;
    public Winner(Cars cars) {
        this.cars = cars;
        this.winners = new ArrayList<>();
        this.winnerPosition = updateMaxPosition();
    }

    private int updateMaxPosition() {
        int maxPosition = 0;
        for(Car car : cars.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public int getWinnerPosition() {
        return winnerPosition;
    }

    public List<Car> getWinners() {
        for (Car car : cars.getCars()) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
