package racingcar.controllers;

import racingcar.services.CarService;
import racingcar.views.InputView;
import racingcar.views.OutPutView;

public class CarController {
    CarService carService = new CarService();

    public void start() {
        InputView.displayInputPrompt();
        String carNames = InputView.readInput();
        carService.createCarModel(carNames);
        InputView.displayTryCountPrompt();
        int tryCount = carService.validateAndParseTryCount(InputView.readInput());
        OutPutView.displayResultMessage();
        for (int i = 0; i < tryCount; i++) {
            carService.incrementCars();
            OutPutView.displayCurrentCarsInfo(carService.getCarsInformation());
        }
        OutPutView.displayWinner(carService.getWinners());
    }

}