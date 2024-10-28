package racingcar;

import racingcar.common.RealRandom;
import racingcar.domain.CarValidator;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {

        RealRandom realRandom = new RealRandom();
        CarValidator carValidator = new CarValidator();

        RacingGame racingGame = new RacingGame(realRandom, carValidator);
        racingGame.start();
    }
}
