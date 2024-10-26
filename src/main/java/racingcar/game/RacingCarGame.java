package racingcar.game;

import java.util.List;
import racingcar.game.io.InputHandler;
import racingcar.game.io.OutputHandler;
import racingcar.game.model.AttemptCount;
import racingcar.game.model.RaceSnapshot;
import racingcar.game.model.RacingCars;
import racingcar.game.model.Winners;

public class RacingCarGame {
    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public void race() {
        outputHandler.showCarInputMessage();
        RacingCars racingCars = inputHandler.getCarNamesFromUser();

        outputHandler.showAttemptCountInputMessage();
        AttemptCount attemptCount = inputHandler.getAttemptCountFromUser();

        displayAccumulateForEachAttempt(attemptCount, racingCars);

        Winners winners = racingCars.retrieveWinners();

        outputHandler.showWinners(winners);
    }

    private void displayAccumulateForEachAttempt(AttemptCount attemptCount, RacingCars racingCars) {
        while (attemptCount.isRemain()) {
            racingCars.race();
            List<RaceSnapshot> snapShots = racingCars.getCurrentSnapshots();
            outputHandler.showCurrentRaceSnapshot(snapShots);
            attemptCount.decrease();
        }
    }
}