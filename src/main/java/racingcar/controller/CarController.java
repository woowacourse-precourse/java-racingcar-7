package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
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
        this.carService = new CarService(new CarGameManager(new ArrayList<>()));
    }

    public void init() {
        try{
            names = inputView.inputNames();
        }catch (Exception e) {
            new IllegalArgumentException();
        }
        totalTimes = inputView.inputTimes();
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
