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
            List<Integer> positions = raceRound();
            results.add(new RoundResult(positions));
        }
        return results;
    }

    public List<Integer> raceRound() {
        return cars.move(moveCondition);
    }

    public List<String> determineWinners(List<Integer> positions) {
        return cars.findWinners(positions);
    }

    public List<Integer> getPositions() {
        return cars.getPositions();
    }
}
