package racingcar;

import racingcar.domain.Race;
import racingcar.strategy.move.RandomMovementStrategy;
import racingcar.strategy.winner.MaxPositionWinnerStrategy;
import racingcar.view.input.InputHandler;
import racingcar.view.output.OutputHandler;

import java.util.Set;

public class Application {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Application(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        Set<String> carNames = inputHandler.inputCarNames();
        int attemptCount = inputHandler.inputAttemptCount();

        Race race = new Race(carNames, attemptCount, new RandomMovementStrategy(), new MaxPositionWinnerStrategy());
        race.start();

        outputHandler.printWinners(race);
    }

    public static void main(String[] args) {
        Application app = new Application(new InputHandler(), new OutputHandler());
        app.run();
    }
}