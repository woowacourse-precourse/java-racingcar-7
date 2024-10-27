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
        RacingCars racingCars = inputHandler.getCarsFromUser();

        outputHandler.showAttemptCountInputMessage();
        AttemptCount attemptCount = inputHandler.getAttemptCountFromUser();

        raceUntilAttemptIsConsumed(attemptCount, racingCars);

        Winners winners = racingCars.retrieveWinners();
        outputHandler.showWinners(winners);
    }

    private void raceUntilAttemptIsConsumed(AttemptCount attemptCount, RacingCars racingCars) {
        attemptCount.runUntilConsumed(() -> {
            racingCars.race();
            List<RaceSnapshot> snapShots = racingCars.getCurrentSnapshots();
            outputHandler.showCurrentRaceSnapshot(snapShots);
        });
    }
}