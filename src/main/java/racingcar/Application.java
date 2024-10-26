package racingcar;

import java.util.ArrayList;
import racingcar.model.attempt.Attempt;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.position.History;
import racingcar.model.position.Positions;
import racingcar.util.comparable.IntegerComparable;
import racingcar.util.comparable.NumberComparable;
import racingcar.exception.InvalidAttemptException;
import racingcar.exception.InvalidNameException;
import racingcar.view.ConsoleInputHandler;
import racingcar.view.ConsoleOutputHandler;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;
import racingcar.util.random.RandomIntegerGenerator;
import racingcar.util.random.RandomNumberGenerator;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RacingCarMovingStrategy;
import racingcar.util.splitter.Splitter;

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

        RacingCar racingCar = new RacingCar(cars, attempt);
        showRacingResult(racingCar, outputHandler);
        String winners = racingCar.calculateWinners();
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

    private static void showRacingResult(final RacingCar racingCar, OutputHandler outputHandler) {
        outputHandler.showCommentForResult();
        racingCar.start();
        Cars cars = racingCar.getCars();
        History history = racingCar.getHistory();
        for (Positions positions : history.values()) {
            outputHandler.showCarPosition(cars.names(), positions.getValues());
        }
    }
}
