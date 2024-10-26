package racingcar.domain;

import java.util.List;

public class ScoreBoard {
    private final List<Car> carList;

    public ScoreBoard(List<Car> carList) {
        this.carList = carList;
    }

    public static ScoreBoard from(List<Car> carList) {
        return new ScoreBoard(carList);
    }
}
