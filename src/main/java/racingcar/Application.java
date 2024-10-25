package racingcar;

import io.ConsoleInputHandler;
import io.ConsoleOutputHandler;
import io.InputHandler;
import io.OutputHandler;
import java.util.ArrayList;
import racingcar.car.Attempt;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.comparable.IntegerComparable;
import racingcar.comparable.NumberComparable;
import racingcar.exception.InvalidAttemptException;
import racingcar.exception.InvalidNameException;
import racingcar.random.RandomIntegerGenerator;
import racingcar.random.RandomNumberGenerator;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RacingCarMovingStrategy;

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

        RandomNumberGenerator randomNumberGenerator = new RandomIntegerGenerator(RANDOM_NUMBER_START_INCLUSIVE,
                RANDOM_NUMBER_END_INCLUSIVE);
        NumberComparable numberComparable = new IntegerComparable();
        MovingStrategy movingStrategy = new RacingCarMovingStrategy(randomNumberGenerator, numberComparable,
                FORWARD_MIN_INCLUSIVE);
        Cars cars = initializeCars(inputNames, movingStrategy);
        Attempt attempt = readAttempt(outputHandler, inputHandler);

        printRacingResult(cars, attempt, outputHandler);
        String winners = cars.calculateWinners();
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

    private static Cars initializeCars(final String inputNames, final MovingStrategy movingStrategy) {
        Cars cars = new Cars(new ArrayList<>());
        for (String name : splitFrom(inputNames)) {
            cars.add(new Car(name, movingStrategy));
        }
        return cars;
    }

    private static String[] splitFrom(final String inputNames) {
        return inputNames.split(COMMA);
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

    private static void printRacingResult(final Cars cars, final Attempt attempt, OutputHandler outputHandler) {
        outputHandler.showCommentForResult();
        for (int i = 0; i < attempt.getValue(); i++) {
            cars.move();
            outputHandler.showCarPosition(cars.getNames(), cars.getPositions());
        }
    }
}
