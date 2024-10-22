package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private final MoveCondition moveCondition;
    private final List<RacingCarState> racingCarStates = new ArrayList<>();
    private final int maxRoundCount;
    private int currentRoundCount;


    public CarGame(MoveCondition moveCondition, int tryCount, List<Car> cars) {
        this.moveCondition = moveCondition;
        this.maxRoundCount = tryCount;
        cars.forEach(car -> racingCarStates.add(new RacingCarState(car)));
        currentRoundCount = 0;
    }

    public boolean canPlay() {
        return currentRoundCount < maxRoundCount;
    }


    public void playOneRound() {
        for (RacingCarState racingCarState : racingCarStates) {
            racingCarState.tryToMove(moveCondition);
        }
        currentRoundCount++;
    }

    public List<RacingCarState> getCurrentRacingCarStates() {
        return racingCarStates;
    }

    public List<String> getTopCarNames() {
        int maxPosition = racingCarStates.stream()
            .mapToInt(RacingCarState::getPosition)
            .max()
            .orElse(0);

        return racingCarStates.stream()
            .filter(racingCarState -> racingCarState.getPosition() == maxPosition)
            .map(RacingCarState::getCarName)
            .toList();
    }
}
