package racingcar;

import racingcar.domain.Car;

import java.util.List;

public class GameConfiguration {
    private String[] carsNames;
    private int attemptCount;

    public GameConfiguration(InputHandler inputHandler, InputParser inputParser) {
        String carNames = inputHandler.inputCarNames();
        this.carsNames = inputParser.parser(carNames);
        this.attemptCount = inputHandler.inputGameCount();
    }

    public String[] carNames() {
        return carsNames;
    }

    public int attemptCount() {
        return attemptCount;
    }

}
