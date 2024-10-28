package racingcar;

import racingcar.domain.RacingGame;
import racingcar.io.InputProcessor;

public class Application {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();
        RacingGame racingGame = new RacingGame(inputProcessor);
        racingGame.start();
    }
}