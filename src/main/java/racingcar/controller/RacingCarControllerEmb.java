package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarEmb;
import racingcar.service.ForwardOrNot;
import racingcar.service.ForwardOrNotEmb;

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
