package racingcar.controller.race;

import racingcar.model.RacingCar;
import racingcar.service.decision.ForwardOrNot;
import racingcar.service.decision.ForwardOrNotEmb;

public class RacingCarControllerEmb implements RacingCarController {
    private final ForwardOrNot forwardOrNot;

    public RacingCarControllerEmb() {
        this.forwardOrNot = new ForwardOrNotEmb();
    }

    @Override
    public void moveForward(RacingCar racingCar) {
        if(forwardOrNot.isBiggerOrEqualFour())
            racingCar.increaseDistance();
    }
}
