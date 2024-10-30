package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.util.RandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.ConsoleInputValidator.*;

public class GameController {
    private static final String CAR_NAME_DELIMITER = ",";
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RandomGenerator randomGenerator;

    public GameController(InputHandler inputHandler, OutputHandler outputHandler, RandomGenerator randomGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.randomGenerator = randomGenerator;
    }

    public void startGame() {
        List<Car> cars = createCars();
        int attempts = getAttemptCount();
        Race race = new Race(cars, attempts);

        outputHandler.showRoundResultHeader();
        String raceResult = race.startRace();
        outputHandler.showRoundResult(raceResult);

        displayWinners(race.getWinners());
    }

    private List<Car> createCars() {
        outputHandler.showCarNamesPrompt();
        String carNamesInput = getValidatedCarNames();
        return convertToCarList(carNamesInput, randomGenerator);
    }

    private String getValidatedCarNames() {
        String carNamesInput = inputHandler.getCarNames();
        validateCarNames(carNamesInput);
        return carNamesInput;
    }

    private List<Car> convertToCarList(String carNamesInput, RandomGenerator randomGenerator) {
        return Arrays.stream(carNamesInput.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(name -> new Car(name, randomGenerator))
                .collect(Collectors.toList());
    }

    private int getAttemptCount() {
        outputHandler.showAttemptCountPrompt();
        int attempts = inputHandler.getAttemptCount();
        validateAttemptCount(attempts);
        return attempts;
    }

    private void displayWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        outputHandler.showWinners(winnersString);
    }
}
