package racingcar.controller;

import java.util.List;
import racingcar.car.RacingCars;
import racingcar.game.RacingCarGame;
import racingcar.generator.Generator;
import racingcar.generator.RandomGenerator;
import racingcar.io.RacingCarIOHandler;

public class RacingCarController {
    private final RacingCarIOHandler ioHandler = new RacingCarIOHandler();
    private final Generator generator = new RandomGenerator();

    public void run() {
        List<String> carNames = ioHandler.askCarNames();
        int round = ioHandler.askRound();

        RacingCarGame racingCarGame = new RacingCarGame(generator);
        RacingCars racingCars = RacingCars.fromNames(carNames);

        String executionResult = racingCarGame.execute(racingCars, round);

        ioHandler.showExecutionResult(executionResult);
        ioHandler.showWinners(racingCars);
    }
}
