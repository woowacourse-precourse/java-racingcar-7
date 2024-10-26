package racingcar;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final MoveCondition moveCondition;

    public RacingGame(Cars cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public List<Integer> play() {
        return cars.move(moveCondition);
    }

    public List<String> getWinners(List<Integer> positions) {
        return cars.getWinners(positions);
    }

    public List<Integer> getPositions() {
        return cars.getPositions();
    }
}
