package controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import model.CarList;
import service.CarService;
import service.InputService;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final InputService inputService;
    private final OutputView outputView;
    private final CarList carList;
    private CarService carService;

    public RacingGameController() {
        this.inputView = new InputView();
        this.inputService = new InputService();
        this.outputView = new OutputView();
        this.carList = new CarList();
    }

    public void initializeCarList() {
        String cars = inputView.inputCars();
        List<String> carNames = inputService.extractValidCarNames(cars);
        carList.setCarList(carNames);

        this.carService = new CarService(carList);
    }

    public int initializeCount() {
        int count = inputView.inputCount();
        return inputService.validateCount(count);
    }

    public void runRace(int count) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            carService.runRoundGame();
            outputView.displayCarsStatus(carList);
        }
    }

    public void displayResults() {
        List<String> winnerList = carService.getWinners();
        outputView.displayWinnerList(winnerList);
    }

    public void run() {
        initializeCarList();
        int count = initializeCount();

        runRace(count);

        displayResults();

        Console.close();
    }
}
