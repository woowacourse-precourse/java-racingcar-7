package racingcar;

import racingcar.domain.Race;
import racingcar.strategy.move.MovementStrategy;
import racingcar.strategy.move.RandomMovementStrategy;
import racingcar.strategy.winner.MaxPositionWinnerStrategy;
import racingcar.strategy.winner.WinnerStrategy;
import racingcar.view.input.InputHandler;
import racingcar.view.output.RaceResultOutput;

import java.util.Set;

public class Application {
    private final InputHandler inputHandler;
    private final MovementStrategy movementStrategy;
    private final WinnerStrategy winnerStrategy;

    public Application(InputHandler inputHandler, MovementStrategy movementStrategy, WinnerStrategy winnerStrategy) {
        this.inputHandler = inputHandler;
        this.movementStrategy = movementStrategy;
        this.winnerStrategy = winnerStrategy;
    }

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        MovementStrategy movementStrategy = new RandomMovementStrategy();
        WinnerStrategy winnerStrategy = new MaxPositionWinnerStrategy();

        Application application = new Application(inputHandler, movementStrategy, winnerStrategy);
        application.run();
    }

    private void run() {
        Set<String> carNames = inputHandler.inputCarNames();
        int attemptCount = inputHandler.inputAttemptCount();

        Race race = new Race(carNames, attemptCount, movementStrategy, winnerStrategy);
        race.start();

        System.out.println(RaceResultOutput.printWinners(race.getWinners()));
    }
}