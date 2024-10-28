package racingcar;

import racingcar.domain.Car;

import java.util.List;

public class GameConfiguration {
    private String[] carsNames;
    private int attemptCount;

    public GameConfiguration(InputHandler inputHandler, InputParser inputParser) {
        String input = inputHandler.inputCarNames();
        Validation.validateDelimiter(input);
        String[] carNames = inputParser.parser(input);
        Validation.validateCarNames(carNames);
        this.carsNames = carNames;

        int gameCount = inputHandler.inputGameCount();
        Validation.validateAttemptCount(String.valueOf(gameCount));
        this.attemptCount = gameCount;
    }

    public String[] carNames() {
        return carsNames;
    }

    public int attemptCount() {
        return attemptCount;
    }

}
