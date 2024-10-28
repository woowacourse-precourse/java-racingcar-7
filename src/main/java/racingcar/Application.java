package racingcar;

import racingcar.controller.DirectionController;
import racingcar.controller.RacingManager;
import racingcar.model.Car;
import racingcar.model.Random;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        Random random = new Random();
        OutputView view = new OutputView();
        DirectionController directionController = new DirectionController();
        RacingManager manager = new RacingManager(car, random, view, directionController);
        manager.start();
    }
}
