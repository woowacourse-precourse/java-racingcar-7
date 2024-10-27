package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.RandomGenerator;

public class RacingGameService {
    private static final int MIN_MOVE_CONDITION = 4;

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (RandomGenerator.createRandomValue() >= MIN_MOVE_CONDITION) {
                car.setForwardCount(car.getForwardCount() + 1);
            }
        }
    }

    public List<String> findFinalWinner(List<Car> cars) {
        List<String> finalWinner = new ArrayList<>();
        int winnerForwardCount = findWinnerForward(cars);
        for (Car car : cars) {
            if (car.getForwardCount() == winnerForwardCount) {
                finalWinner.add(car.getName());
            }
        }
        return finalWinner;
    }

    private int findWinnerForward(List<Car> cars) {
        return cars.stream().mapToInt(Car::getForwardCount).max().orElse(0);
    }

}
