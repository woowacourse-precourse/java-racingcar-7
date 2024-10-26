package racingcar.model;

import java.util.List;

public class RacingGameRoundResult {
    private List<Car> cars;
    private int round;

    public RacingGameRoundResult(List<Car> cars, int round) {
        this.round = round;
        this.cars = cars;
    }

    public int getRound() {
        return round;
    }

    public List<Car> getCars() {
        return cars;
    }
}
