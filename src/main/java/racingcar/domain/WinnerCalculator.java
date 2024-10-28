package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {
    private final List<Car> racingCarList;

    public WinnerCalculator(List<Car> racingCarList) {
        this.racingCarList = racingCarList;
    }

    private int getMaxScore() {
        return racingCarList.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }
}
