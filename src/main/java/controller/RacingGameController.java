package controller;

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

    public RacingGameController() {
        this.inputView = new InputView();
        this.inputService = new InputService();
        this.outputView = new OutputView();
        this.carList = new CarList();
    }

    public void run() {
        String cars = inputView.inputCars();
        List<String> carNames = inputService.extractValidCarNames(cars);
        carList.setCarList(carNames);

        CarService carService = new CarService(carList);

        int count = inputView.inputCount();
        count = inputService.validateCount(count);

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            carService.runRoundGame();
            outputView.displayCarsStatus(carList);
        }

        List<String> winnerList = carService.getWinners();
        outputView.displayWinnerList(winnerList);
    }
}
