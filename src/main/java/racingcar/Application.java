package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RacingCarMovingStrategy;
import racingcar.util.comparable.IntegerComparable;
import racingcar.util.comparable.NumberComparable;
import racingcar.util.random.RandomIntegerGenerator;
import racingcar.util.random.RandomNumberGenerator;
import racingcar.util.splitter.Splitter;
import racingcar.view.ConsoleInputHandler;
import racingcar.view.ConsoleOutputHandler;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class Application {

    private static final int RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final int RANDOM_NUMBER_END_INCLUSIVE = 9;
    private static final int FORWARD_MIN_INCLUSIVE = 4;

    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        Splitter splitter = new Splitter();
        RandomNumberGenerator randomNumberGenerator = new RandomIntegerGenerator(RANDOM_NUMBER_START_INCLUSIVE,
                RANDOM_NUMBER_END_INCLUSIVE);
        NumberComparable numberComparable = new IntegerComparable();
        MovingStrategy movingStrategy = new RacingCarMovingStrategy(randomNumberGenerator, numberComparable,
                FORWARD_MIN_INCLUSIVE);
        RacingCarController controller = new RacingCarController(inputHandler, outputHandler, splitter, movingStrategy);
        controller.process();
    }
}
