package racingcar;

import racingcar.controller.CarController;
import racingcar.util.generator.Generator;
import racingcar.util.generator.IntegerGenerator;
import racingcar.util.movement.CarMoveStrategy;
import racingcar.util.movement.MoveStrategy;
import racingcar.util.parser.InputParser;
import racingcar.util.parser.InputSplitter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MoveStrategy moveStrategy = new CarMoveStrategy();
        InputParser inputParser = new InputSplitter();
        Generator<Integer> generator = new IntegerGenerator();
        CarController carController = new CarController(moveStrategy, inputParser, generator);

        carController.play();
    }
}
