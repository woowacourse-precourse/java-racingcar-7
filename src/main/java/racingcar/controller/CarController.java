package racingcar.controller;

import racingcar.domain.CarGameManager;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    public InputView inputView;
    public OutputView outputView;
    public String[] names;
    public int totalTimes;
    public CarService carService;

    public CarController() {
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

        carGameManager = new CarGameManager(names, totalTimes);
        outputView.printResultMessage();
    }

    private void playRace() {
        for (int i = 0; i < carGameManager.getTotalTimes(); i++) {
            carGameManager.startEachStep();
            outputView.printEachStep(carGameManager.getCars());
        }
    }

    private void displayWinners() {
        outputView.printWinners(carGameManager.getWinners());
    }
}
