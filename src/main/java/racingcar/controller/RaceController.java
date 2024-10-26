package racingcar.controller;

import racingcar.service.RaceManager;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceManager raceManager;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.raceManager = initializeGame();
    }

    private RaceManager initializeGame() {
        String[] names = inputView.inputNames();
        InputValidator.validateName(names);
        int totalTimes = inputView.inputTimes();

        outputView.printResultMessage();
        return new RaceManager(names, totalTimes);
    }

    public void startGame() {
        playRace();
        displayWinners();
    }

    private void playRace() {
        for (int i = 0; i < raceManager.getTotalTimes(); i++) {
            raceManager.startEachStep();
            outputView.printEachStep(raceManager.getCars());
        }
    }

    private void displayWinners() {
        outputView.printWinners(raceManager.getWinners());
    }
}
