package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {
    private final List<Car> racingCarList;

    public WinnerCalculator(List<Car> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxScore = getMaxScore();
        for (Car car : racingCarList) {
            if (car.getMoveCount() == maxScore) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
    private int getMaxScore() {
        return racingCarList.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }
}
