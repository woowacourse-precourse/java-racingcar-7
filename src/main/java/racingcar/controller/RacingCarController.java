package racingcar.controller;

import java.util.List;
import racingcar.controller.strategy.MoveStrategy;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.input.InputView;
import racingcar.view.output.OutPutView;

public class RacingCarController {

    private final InputView inputView;
    private final OutPutView outputView;
    private final MoveStrategy moveStrategy;

    public RacingCarController(final InputView inputView, final OutPutView outputView,
                               final MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void startRace() {
        final Race race = initializeRace();
        runRace(race);
        finishRace(race);
    }

    private Race initializeRace() {
        final String carNames = inputView.inputCarNames();
        final String numberOfAttempts = inputView.inputNumberOfAttempts();
        return new Race(carNames, moveStrategy, numberOfAttempts);
    }

    private void runRace(final Race race) {
        outputView.printMessage();
        while (race.hasNext()) {
            final List<Car> cars = race.next();
            outputView.printResult(cars);
        }
    }

    private void finishRace(final Race race) {
        final List<Car> winners = race.finish();
        outputView.printWinners(winners);
    }
}
