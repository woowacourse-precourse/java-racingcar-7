package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> carList;
    private final int number;
    public RacingGame(List<Car> carList, int num) {
        this.carList = carList;
        this.number = num;
    }
}
