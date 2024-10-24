package racingcar.game;

import racingcar.generator.RandomNumberGenerator;

public class RacingGameControllerFactory {

    public static RacingGameController create() {
        return new RacingGameController(racingGame());
    }

    private static RacingGame racingGame() {
        return new RacingGame(numberGenerator());
    }

    private static RandomNumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }

}
