package racingcar.Controller;

import java.util.List;
import racingcar.Model.Car;
import racingcar.Model.RaceRecord;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class CarRacingGame implements Game {
    private static final int MOVE_DISTANCE = 1;
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;
    RaceRecord raceRecord;
    int moveAttemptCount;

    public CarRacingGame(List<String> carNames, int moveAttemptCount) {
        this.moveAttemptCount = moveAttemptCount;
        this.raceRecord = new RaceRecord(carNames);
    }

    private void attemptMoveSingleCar(Car car) {
        if (isMoveAble()) {
            moveForward(car);
        }
    }

    private boolean isMoveAble() {
        return Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX) > MOVE_THRESHOLD;
    }

    private void moveForward(Car car) {
        raceRecord.updateCarRecord(car, MOVE_DISTANCE);
    }
}
