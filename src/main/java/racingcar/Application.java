package racingcar;

import racingcar.controller.GameController;
import racingcar.model.CarHandler;
import racingcar.validate.Validation;

public class Application {
    public static void main(String[] args) {
        final CarHandler carHandler = new CarHandler();
        final Validation validation = new Validation();

        final GameController gameController = new GameController(carHandler, validation);
        gameController.start();
    }
}
