package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.enums.ViewMessage;

public class Race {
    private final List<Car> cars;
    private int maxMoveCount = 0;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void runRace() {
        for (Car car : cars) {
            car.move();
            maxMoveCount = Math.max(maxMoveCount, car.moveCount);
        }
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.moveCount == maxMoveCount) {
                winners.add(car.name);
            }
        }
        return winners;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car).append(ViewMessage.PRINT_BLANK.getMessage());
        }
        return stringBuilder.toString();
    }
}
