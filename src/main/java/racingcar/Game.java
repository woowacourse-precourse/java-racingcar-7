package racingcar;

import java.util.List;

public class Game {

    private final Cars cars;
    private final MoveCondition moveCondition;

    public Game(Cars cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public List<Integer> race() {
        return cars.go(moveCondition);
    }
}
