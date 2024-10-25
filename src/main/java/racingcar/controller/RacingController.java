package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

public class RacingController {

    private final RacingCarView racingCarView;

    public RacingController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void run() {
        List<String> racingCarNames = racingCarView.getRacingCarNames();
        RacingCars racingCars = RacingCars.of(racingCarNames);

        int attemptCount = racingCarView.getAttemptCount();
        for (int i = 0; i < attemptCount; i++) {
            racingCars.race();
        }

        List<RacingCar> winners = racingCars.getWinners();
    }

}
