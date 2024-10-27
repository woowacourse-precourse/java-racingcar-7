package racingcar;

import racingcar.util.RacingCarInput;
import racingcar.util.RacingCarOutput;

public class Application {
    public static void main(String[] args) {

        RacingCarInput racingCarInput = new RacingCarInput();
        RacingCarOutput racingCarOutput = new RacingCarOutput();

        RacingGame racingGame = new RacingGame(racingCarInput, racingCarOutput);
        racingGame.start();
    }
}
