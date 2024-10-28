package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.CarsNameParser;
import racingcar.model.InputValidator;
import racingcar.view.RaceView;
import racingcar.view.SystemView;

import java.util.Set;

public class RacingGameController {
    private final SystemView systemView;
    private final RaceView raceView;
    private final Cars cars;

    public RacingGameController(SystemView systemView, RaceView raceView, Cars cars) {
        this.systemView = systemView;
        this.raceView = raceView;
        this.cars = cars;
    }

    public void run() {
        handleCarNamesInput();
        handleTrialInput();
        startRace();
        displayWinner();
    }

    private void handleCarNamesInput() {
        String nameInput = systemView.printSystemNameInputMessage();
        Set<String> carNames = CarsNameParser.parse(nameInput);
        cars.addCars(carNames);
        cars.registerObserver(raceView);
    }

    private void handleTrialInput() {
        String trialInput = systemView.printSystemInputTrialMessage();
        InputValidator.validateTrialInput(trialInput);
        cars.setTrialCount(Integer.parseInt(trialInput));
    }

    private void startRace() {
        systemView.printSystemRaceStartMessage();
        cars.repeatGo();
    }

    private void displayWinner() {
        systemView.printSystemWinneMessage();
        raceView.displayWinner();
    }
}
