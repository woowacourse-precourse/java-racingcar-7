package racingcar.controller;

import racingcar.service.RaceManager;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private RaceManager raceManager;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        initializeGame();
        playRace();
        displayWinners();
    }

    private void initializeGame() {
        String[] names = inputView.inputNames();
        InputValidator.validateName(names);
        int totalTimes = inputView.inputTimes();

        raceManager = new RaceManager(names, totalTimes);
        outputView.printResultMessage();
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
