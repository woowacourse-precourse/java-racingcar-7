package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCar racingCar;

    public RacingCarController() {
        this.racingCar = new RacingCar();
    }

    public void Run(){

        String carsInput = RacingCarView.getCarsInput();
        String attemptInput = RacingCarView.getAttemptInput();

        racingCar.racing(carsInput, attemptInput);
    }
}
