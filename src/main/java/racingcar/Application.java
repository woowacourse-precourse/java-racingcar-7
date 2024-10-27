package racingcar;

import racingcar.controller.CarController;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.movement.CarMoveStrategy;
import racingcar.util.movement.MoveStrategy;
import racingcar.util.parser.InputSplitter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MoveStrategy moveStrategy = new CarMoveStrategy();
        InputSplitter inputSplitter = new InputSplitter();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        CarController carController = new CarController(moveStrategy, inputSplitter, randomNumberGenerator);

        carController.play();
    }
}
