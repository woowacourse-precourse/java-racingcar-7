package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingSimulation {

    public List<CarRecord> simulateRace(List<String> carNames, Integer tryCount) {
        List<CarRecord> raceResult = new ArrayList<>();
        for (String carName : carNames) {
            CarRecord carProgress = new CarRecord(carName);
            recordCarProgress(carProgress, tryCount);
            raceResult.add(carProgress);
        }
        return raceResult;
    }

    private boolean shouldMove() {
        Integer move = Randoms.pickNumberInRange(0, 9);
        return move >= 4;
    }

    private void recordCarProgress(CarRecord carRecord, Integer tryCount) {
        for (int i = 1; i <= tryCount; i++) {
            Integer beforeMoveCount = carRecord.getMoveCount(i - 1);
            if (shouldMove()) {
                carRecord.addMoveCount(1 + beforeMoveCount);
            } else {
                carRecord.addMoveCount(beforeMoveCount);
            }
        }
    }
}
