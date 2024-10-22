package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;

public class CarController {

    private final InputView inputView;
    private final CarService carService;

    public CarController(){
        this.inputView = new InputView();
        this.carService = new CarService();
    }

    public void run(){
        String inputCarName = inputView.inputCarName();
        String result = carService.racing(inputCarName);
    }
}
