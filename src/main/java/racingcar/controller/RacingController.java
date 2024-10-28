package racingcar.controller;

import java.util.List;
import racingcar.model.MovementFactorGenerator;
import racingcar.model.RacingCarSnapShot;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

public class RacingController {

    private final RacingCarView racingCarView;
    private final MovementFactorGenerator movementFactorGenerator;

    public RacingController(RacingCarView racingCarView, MovementFactorGenerator movementFactorGenerator) {
        this.racingCarView = racingCarView;
        this.movementFactorGenerator = movementFactorGenerator;
    }

    public void run() {
        List<String> racingCarNames = racingCarView.getRacingCarNames();
        RacingCars racingCars = RacingCars.of(racingCarNames, movementFactorGenerator);

        int attemptCount = racingCarView.getAttemptCount();
        racingCarView.showRaceResultComment();
        for (int i = 0; i < attemptCount; i++) {
            List<RacingCarSnapShot> snapShots = racingCars.race();
            racingCarView.showRaceResult(snapShots);
        }

        List<String> winners = racingCars.getWinners();
        racingCarView.showWinners(winners);
    }

}
