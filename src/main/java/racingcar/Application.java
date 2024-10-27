package racingcar;

import racingcar.controller.GameController;
import racingcar.model.CarHandler;

public class Application {
    public static void main(String[] args) {
        final CarHandler carHandler = new CarHandler();

        final GameController gameController = new GameController(carHandler);
        gameController.start();
    }
}
