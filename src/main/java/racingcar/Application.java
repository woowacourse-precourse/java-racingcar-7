package racingcar;

import racingcar.controller.CarsController;
import racingcar.domain.Cars;
import racingcar.service.CarsService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import random.CarRandom;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarRandom carRandom = new CarRandom();

        CarsService carsService = new CarsService(null);

        CarsController carsController = new CarsController(inputView, outputView, carRandom, carsService);

        carsController.startCarsMove();
    }
}
