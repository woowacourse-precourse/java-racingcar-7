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
        if(!canPlay()) { // 방어 로직
            throw new IllegalStateException("게임이 끝났습니다.");
        }

        for (RacingCarState racingCarState : racingCarStates) {
            racingCarState.tryToMove(moveCondition);
        }
        currentRoundCount++;
    }

    public List<RacingCarState> getCurrentRacingCarStates() {
        return racingCarStates;
    }

    /**
     * 현재 가장 멀리 나간 자동차의 위치를 구한다.
     * 그후 해당 위치에 있는 자동차들의 이름을 반환한다.
     */
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
