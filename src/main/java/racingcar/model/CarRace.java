package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RoundRaceRecord;

public class CarRace {

    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final Cars cars;
    private final int roundCount;
    private int currentRoundCount = 0;

    public CarRace(Cars cars, int roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public List<RoundRaceRecord> startRound() {
        validateExecuteRaceRound();
        currentRoundCount++;
        moveCarsIfAble();
        return getRoundRaceRecord();
    }

    private void validateExecuteRaceRound() {
        if (!hasMoreRounds()) {
            throw new IllegalStateException("더 이상 라운드를 진행할 수 없습니다. (이미 종료된 경주입니다.)");
        }
    }

    private void moveCarsIfAble() {
        for (Car car : cars.getCars()) {
            if (canMove()) {
                car.moveForward();
            }
        }
    }

    private List<RoundRaceRecord> getRoundRaceRecord() {
        return cars.getCars()
                .stream()
                .map(this::mapToRoundRaceRecord)
                .toList();
    }

    private RoundRaceRecord mapToRoundRaceRecord(Car car) {
        return new RoundRaceRecord(car.getName(), car.getPosition());
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END) >= MOVE_THRESHOLD;
    }

    public boolean hasMoreRounds() {
        return currentRoundCount < roundCount;
    }

    public List<String> getWinnerCarNames() {
        if (hasMoreRounds()) {
            throw new IllegalStateException("자동차 경주가 종료되지 않았습니다.");
        }
        List<String> winnerCarNames = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winnerCarNames = new ArrayList<>();
                winnerCarNames.add(car.getName());
                continue;
            }
            if (car.getPosition() == maxPosition) {
                winnerCarNames.add(car.getName());
            }
        }
        return winnerCarNames;
    }
}
