package racingcar.controller;

import racingcar.domain.Car;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.ConsoleInputValidator.*;

public class GameController {
    private static final String CAR_NAME_DELIMITER = ",";
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public GameController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void startGame() {
        List<Car> cars = createCars();
        int attempts = getAttemptCount();
    }

    private List<Car> createCars() {
        outputHandler.showCarNamesPrompt();
        String carNamesInput = getValidatedCarNames();
        return convertToCarList(carNamesInput);
    }

    private String getValidatedCarNames() {
        String carNamesInput = inputHandler.getCarNames();
        validateCarNames(carNamesInput);
        return carNamesInput;
    }

    private List<Car> convertToCarList(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getAttemptCount() {
        outputHandler.showAttemptCountPrompt();
        int attempts = inputHandler.getAttemptCount();
        validateAttemptCount(attempts);
        return attempts;
    }

}
