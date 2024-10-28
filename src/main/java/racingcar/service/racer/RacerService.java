package racingcar.service.racer;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.Car;
import racingcar.service.constant.RacingRules;

public class RacerService {

    private Boolean pedaling() {
        return engineTorque() >= RacingRules.ENOUGH_TORQUE_OUTPUT.status();
    }

    private Integer engineTorque() {
        return pickNumberInRange(
                RacingRules.TORQUE_RANGE_MIN.intStatus()
                ,RacingRules.TORQUE_RANGE_MAX.intStatus());
    }
}
