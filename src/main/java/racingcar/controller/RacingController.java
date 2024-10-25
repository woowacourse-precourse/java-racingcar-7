package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCarSnapShot;
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
        racingCarView.showRaceResultComment();
        for (int i = 0; i < attemptCount; i++) {
            racingCars.race();
            List<RacingCarSnapShot> snapShots = racingCars.getCarSnapShots();
            racingCarView.showRaceResult(snapShots);
        }

        List<RacingCar> winners = racingCars.getWinners();
    }

}
