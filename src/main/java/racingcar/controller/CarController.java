package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;

import java.util.Map;

public class CarController {

    private final InputView inputView;
    private final CarService carService;

    public CarController(){
        this.inputView = new InputView();
        this.carService = new CarService();
    }

    public void run(){
        String inputCarName = inputView.inputCarName();
        Map<String, Integer> cars = carService.carNames(inputCarName);
        int inputCount = inputView.getAttemptCount();
        cars = carService.racing(cars, inputCount);

    }
}
