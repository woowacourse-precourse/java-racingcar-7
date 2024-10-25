package racingcar;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final MoveCondition moveCondition;

    public RacingGame(Cars cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public List<Integer> race() {
        return cars.go(moveCondition);
    }
}
