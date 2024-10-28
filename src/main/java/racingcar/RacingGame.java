package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final MoveCondition moveCondition;
    private final int tryCount;

    public RacingGame(Cars cars, MoveCondition moveCondition) {
        this(cars, moveCondition, 0);
    }

    public RacingGame(Cars cars, MoveCondition moveCondition, int tryCount) {
        this.cars = cars;
        this.moveCondition = moveCondition;
        this.tryCount = tryCount;
    }

    public List<RoundResult> determineRoundResult() {
        List<RoundResult> results = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            raceRound();
            results.add(new RoundResult(cars.getPositions()));
        }
        return results;
    }

    public void raceRound() {
        cars.move(moveCondition);
    }

    public List<String> determineWinners(List<Position> positions) {
        return cars.findWinners(positions);
    }

    public List<Position> getPositions() {
        return cars.getPositions();
    }
}
