package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputHandler(), new OutputHandler());
        racingGame.run();
    }
}
