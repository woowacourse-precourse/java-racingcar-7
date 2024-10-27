package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Cars;

public class Application {
    public static void main(String[] args) {
        final Cars cars = new Cars();

        final GameController gameController = new GameController(cars);
        gameController.start();
    }
}
