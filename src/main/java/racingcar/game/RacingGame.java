package racingcar.game;

import racingcar.car.Cars;
import racingcar.input.InputHandler;
import racingcar.input.UserInput;
import racingcar.input.Validator;
import racingcar.observer.CarMovePrinter;
import racingcar.output.OutputHandler;
import racingcar.util.RandomValueGenerator;
import racingcar.util.StringSplitter;

import java.util.List;

public class RacingGame {

    private final InputHandler inputHandler;
    private final Validator validator;
    private final RandomValueGenerator randomValueGenerator;
    private final OutputHandler outputHandler;

    public RacingGame(InputHandler inputHandler,
                      Validator validator,
                      RandomValueGenerator randomValueGenerator,
                      OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.validator = validator;
        this.randomValueGenerator = randomValueGenerator;
        this.outputHandler = outputHandler;
    }

    public void start() {
        UserInput userInput = getValidatedUserInput();
        Cars cars = initCars(userInput.carNames());
        int attemptCount = Integer.parseInt(userInput.attemptCount());

        outputHandler.outputMessageWithNewLine("실행결과");
        runRaceRounds(cars, attemptCount);
        outputHandler.displayWinners(cars.getWinners());
    }

    private UserInput getValidatedUserInput() {
        UserInput userInput = inputHandler.inputCarNamesAndAttemptCount();
        validator.validateInput(userInput);
        return userInput;
    }

    private Cars initCars(String carNames) {
        Cars cars = new Cars(StringSplitter.splitByComma(carNames));
        cars.addObserverToAll(CarMovePrinter.class, outputHandler);
        return cars;
    }

    private void runRaceRounds(Cars cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            runRaceRound(cars);
            outputHandler.outputNewLine();
        }
    }

    private void runRaceRound(Cars cars) {
        List<Integer> randomValues = randomValueGenerator.generateMultiple(0, 9, cars.size());
        cars.moveAll(randomValues);
    }
}