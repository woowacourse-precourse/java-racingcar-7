package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.Map;

public class RacingRoundService {

    public void racingRound(Map<String, Integer> racingCars) {
        for (String carName : racingCars.keySet()) {
            moveOneStepIfPossible(racingCars, carName);
        }
    }

    private boolean canGo() {
        return pickNumberInRange(0,9) > 3;
    }

    private void moveOneStepIfPossible(Map<String, Integer> racingCars, String carName) {
        if (canGo()) {
            racingCars.compute(carName, (k, carState) -> carState + 1);
        }
    }

}
