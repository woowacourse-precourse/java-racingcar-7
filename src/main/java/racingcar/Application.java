package racingcar;

import java.util.ArrayList;
import racingcar.car.Attempt;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.car.History;
import racingcar.car.Positions;
import racingcar.car.RacingGame;
import racingcar.comparable.IntegerComparable;
import racingcar.comparable.NumberComparable;
import racingcar.exception.InvalidAttemptException;
import racingcar.exception.InvalidNameException;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.random.RandomIntegerGenerator;
import racingcar.random.RandomNumberGenerator;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RacingCarMovingStrategy;
import racingcar.util.Splitter;

public class Application {

    private static final int RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final int RANDOM_NUMBER_END_INCLUSIVE = 9;
    private static final int FORWARD_MIN_INCLUSIVE = 4;
    private static final String COMMA = ",";

    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        String inputNames = readNames(outputHandler, inputHandler);
        validateInputNames(inputNames);

        Splitter splitter = new Splitter();
        RandomNumberGenerator randomNumberGenerator = new RandomIntegerGenerator(RANDOM_NUMBER_START_INCLUSIVE,
                RANDOM_NUMBER_END_INCLUSIVE);
        NumberComparable numberComparable = new IntegerComparable();
        MovingStrategy movingStrategy = new RacingCarMovingStrategy(randomNumberGenerator, numberComparable,
                FORWARD_MIN_INCLUSIVE);
        Cars cars = initializeCars(splitter, inputNames, movingStrategy);
        Attempt attempt = readAttempt(outputHandler, inputHandler);

        RacingGame racingGame = new RacingGame(cars, attempt);
        showRacingResult(racingGame, outputHandler);
        String winners = racingGame.calculateWinners();
        outputHandler.showWinners(winners);
    }

    private static String readNames(OutputHandler outputHandler, InputHandler inputHandler) {
        outputHandler.showCommentForCarNames();
        return inputHandler.read();
    }

    private static void validateInputNames(final String value) {
        if (value.endsWith(COMMA)) {
            throw new InvalidNameException("이름은 비어있을 수 없습니다.");
        }
    }

    private static Cars initializeCars(final Splitter splitter, final String inputNames,
                                       final MovingStrategy movingStrategy) {
        Cars cars = new Cars(new ArrayList<>());
        for (String name : splitter.splitFrom(inputNames, COMMA)) {
            cars.add(new Car(name, movingStrategy));
        }
        return cars;
    }

    private static Attempt readAttempt(OutputHandler outputHandler, InputHandler inputHandler) {
        outputHandler.showCommentForAttempt();
        String inputAttempt = inputHandler.read();
        validateInputAttempt(inputAttempt);

        return new Attempt(Long.parseLong(inputAttempt));
    }

    private static void validateInputAttempt(final String inputAttempt) {
        if (inputAttempt == null || inputAttempt.isBlank()) {
            throw new InvalidAttemptException("시도 횟수는 null이거나 공백일 수 없습니다.");
        }
    }

    private static void showRacingResult(final RacingGame racingGame, OutputHandler outputHandler) {
        outputHandler.showCommentForResult();
        racingGame.start();
        Cars cars = racingGame.getCars();
        History history = racingGame.getHistory();
        for (Positions positions : history.values()) {
            outputHandler.showCarPosition(cars.names(), positions.getValues());
        }
    }
}
