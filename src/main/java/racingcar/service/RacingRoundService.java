package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.constant.Constant.*;
import java.util.Map;

public class RacingRoundService {
    private static RacingRoundService racingRoundService;

    private RacingRoundService() {}

    public static RacingRoundService getRacingRoundServiceInstance() {
        if (racingRoundService == null) {
            racingRoundService = new RacingRoundService();
            return racingRoundService;
        }
        return racingRoundService;
    }

    public void racingRound(Map<String, Integer> racingCars) {
        for (String carName : racingCars.keySet()) {
            moveOneStepIfPossible(racingCars, carName);
        }
    }

    private boolean canGo() {
        return pickNumberInRange(RANDOM_BOUND_START, RANDOM_BOUND_END) >= MOVE_POSSIBLE_STANDARD;
    }

    private void moveOneStepIfPossible(Map<String, Integer> racingCars, String carName) {
        if (canGo()) {
            racingCars.compute(carName, (k, carPosition) -> carPosition + 1);
        }
    }

}
