package racingcar.game;

import java.util.List;
import racingcar.game.io.InputHandler;
import racingcar.game.io.OutputHandler;
import racingcar.game.model.AttemptCount;
import racingcar.game.model.Car;
import racingcar.game.model.RacingCars;

public class RacingCarGame {
    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public void race() {
        outputHandler.showCarNamesNavigateMessage();
        List<Car> cars = inputHandler.getCarNamesFromUser();

        outputHandler.showAttemptCountNavigateMessage();
        AttemptCount attemptCount = inputHandler.getAttemptCountFromUser();

        RacingCars racingCars = new RacingCars(cars);
        displayAccumulateForEachAttempt(attemptCount, racingCars);

        List<Car> winners = racingCars.retrieveWinners();

        outputHandler.showWinners(winners);
    }

    private void displayAccumulateForEachAttempt(AttemptCount attemptCount, RacingCars racingCars) {
        while (attemptCount.isRemain()) {
            racingCars.race();
            outputHandler.showCurrentAccumulation(racingCars);
            attemptCount.decrease();
        }
    }
}