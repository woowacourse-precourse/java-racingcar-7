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

    public CarRace(Cars cars) {
        this.cars = cars;
    }

    public List<RoundRaceRecord> startRound() {
        moveCarsIfAble();
        return getRoundRaceRecord();
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

    public List<String> getWinnerCarNames() {
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
