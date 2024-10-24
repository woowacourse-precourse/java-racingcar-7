package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.validation.CarNamesValidator;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameView();
        CarNamesValidator carNamesValidator = new CarNamesValidator();

        new RacingGameController(
            racingGameView,
            carNamesValidator
        ).play();
    }
}
