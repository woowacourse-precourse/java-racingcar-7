package racingcar.service.racer;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.Car;
import racingcar.service.constant.RacingRules;

public class RacerService {

    private Integer engineTorque() {
        return pickNumberInRange(0,9);
    }
}
