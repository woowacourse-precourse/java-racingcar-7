package racingcar;

import racingcar.domain.Race;
import racingcar.strategy.move.RandomMovementStrategy;
import racingcar.strategy.winner.MaxPositionWinnerStrategy;
import racingcar.view.input.InputHandler;
import racingcar.view.output.RaceResultOutput;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        Set<String> carNames = inputHandler.inputCarNames();

        int attemptCount = inputHandler.inputAttemptCount();

        RandomMovementStrategy movementStrategy = new RandomMovementStrategy();
        MaxPositionWinnerStrategy winnerStrategy = new MaxPositionWinnerStrategy();

        Race race = new Race(carNames, attemptCount, movementStrategy, winnerStrategy);
        race.start();

        System.out.println(RaceResultOutput.printWinners(race.getWinners()));
    }
}