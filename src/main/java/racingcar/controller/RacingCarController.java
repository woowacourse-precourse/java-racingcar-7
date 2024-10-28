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
        RacingCars racingCars = createRacingCars();
        AttemptCount attemptCount = getAttemptCount();

        race(racingCars, attemptCount);

        showGameResult(racingCars);
    }

    private RacingCars createRacingCars() {
        List<String> racingCarNames = racingCarView.getRacingCarNames();
        return RacingCars.of(racingCarNames, movementFactorGenerator);
    }

    private AttemptCount getAttemptCount() {
        int count = racingCarView.getAttemptCount();
        return new AttemptCount(count);
    }

    private void race(RacingCars racingCars, AttemptCount attemptCount) {
        racingCarView.showRaceResultComment();
        while (attemptCount.isRemain()) {
            List<RacingCarSnapShot> snapShots = racingCars.race();
            racingCarView.showRaceResult(snapShots);
            attemptCount.decrease();
        }
    }

    private void showGameResult(RacingCars racingCars) {
        List<String> winners = racingCars.getWinners();
        racingCarView.showWinners(winners);
    }

}
