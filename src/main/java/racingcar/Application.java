package racingcar;

import racingcar.common.RealRandom;
import racingcar.domain.CarValidator;
import racingcar.domain.RacingGame;
import racingcar.domain.TurnValidator;

public class Application {
    public static void main(String[] args) {

        RealRandom realRandom = new RealRandom();
        CarValidator carValidator = new CarValidator();
        TurnValidator turnValidator = new TurnValidator();

        RacingGame racingGame = new RacingGame(realRandom, carValidator, turnValidator);
        racingGame.start();
    }
}
