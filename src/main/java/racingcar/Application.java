package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RacingCarMovingStrategy;
import racingcar.util.StringRepeater;
import racingcar.util.comparable.IntegerComparable;
import racingcar.util.comparable.NumberComparable;
import racingcar.util.random.RandomIntegerGenerator;
import racingcar.util.random.RandomNumberGenerator;
import racingcar.util.splitter.Splitter;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final String DELIMITER = ",";
    private static final int RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final int RANDOM_NUMBER_END_INCLUSIVE = 9;
    private static final int FORWARD_MIN_INCLUSIVE = 4;
    private static final String HYPHEN = "-";

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        Splitter splitter = new Splitter(DELIMITER);
        RandomNumberGenerator randomNumberGenerator = new RandomIntegerGenerator(RANDOM_NUMBER_START_INCLUSIVE,
                RANDOM_NUMBER_END_INCLUSIVE);
        NumberComparable numberComparable = new IntegerComparable();
        MovingStrategy movingStrategy = new RacingCarMovingStrategy(randomNumberGenerator, numberComparable,
                FORWARD_MIN_INCLUSIVE);
        StringRepeater stringRepeater = new StringRepeater(HYPHEN);

        RacingCarController controller = new RacingCarController(inputView, outputView, splitter, movingStrategy,
                stringRepeater);
        controller.process();
        Console.close();
    }
}
