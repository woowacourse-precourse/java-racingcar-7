package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.CarsNameParser;
import racingcar.model.InputValidator;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

import java.util.Set;

public class RacingGameController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Cars cars;

    public RacingGameController(InputHandler inputHandler, OutputHandler outputHandler, Cars cars) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.cars = cars;
    }

    public void run() {
        handleCarNamesInput();
        handleTrialInput();
        startRace();
        displayWinner();
    }

    private void handleCarNamesInput() {
        String nameInput = inputHandler.printSystemNameInputMessage();
        Set<String> carNames = CarsNameParser.parse(nameInput);
        cars.addCars(carNames);
    }

    private void handleTrialInput() {
        String trialInput = inputHandler.printSystemInputTrialMessage();
        InputValidator.validateTrialInput(trialInput);
        cars.setTrialCount(Integer.parseInt(trialInput));
    }

    private void startRace() {
        outputHandler.printRaceStartMessage();
        cars.repeatGo();
    }

    private void displayWinner() {
        outputHandler.printWinnerMessage();
        outputHandler.displayWinner();
    }
}

