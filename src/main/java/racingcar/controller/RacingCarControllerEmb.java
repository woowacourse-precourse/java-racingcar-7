package racingcar.controller;

import racingcar.model.RacingCarEmb;
import racingcar.service.ForwardOrNotEmb;

public class RacingCarControllerEmb implements RacingCarController {
    private final RacingCarEmb racingCar;
    private final ForwardOrNotEmb forwardOrNot;
    public RacingCarControllerEmb(RacingCarEmb racingCar, ForwardOrNotEmb forwardOrNot) {
        this.racingCar = racingCar;
        this.forwardOrNot = forwardOrNot;
    }

    @Override
    public void moveForward() {
        if(forwardOrNot.isBiggerOrEqualFour())
            racingCar.increaseDistance();
    }
}
