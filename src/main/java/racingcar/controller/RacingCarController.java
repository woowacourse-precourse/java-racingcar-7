package racingcar.controller;

import java.util.List;
import racingcar.model.AttemptCount;
import racingcar.model.MovementFactorGenerator;
import racingcar.model.RacingCarSnapShot;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;
    private final MovementFactorGenerator movementFactorGenerator;

    public RacingCarController(RacingCarView racingCarView, MovementFactorGenerator movementFactorGenerator) {
        this.racingCarView = racingCarView;
        this.movementFactorGenerator = movementFactorGenerator;
    }

    public void run() {
        List<String> racingCarNames = racingCarView.getRacingCarNames();
        RacingCars racingCars = RacingCars.of(racingCarNames, movementFactorGenerator);

        int count = racingCarView.getAttemptCount();
        AttemptCount attemptCount = new AttemptCount(count);

        racingCarView.showRaceResultComment();
        while (attemptCount.isRemain()) {
            List<RacingCarSnapShot> snapShots = racingCars.race();
            racingCarView.showRaceResult(snapShots);
            attemptCount.decrease();
        }

        List<String> winners = racingCars.getWinners();
        racingCarView.showWinners(winners);
    }

}
