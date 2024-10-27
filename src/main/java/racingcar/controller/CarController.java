package racingcar.controller;

import racingcar.view.InputView;
import racingcar.model.Car;

import java.util.List;

public class CarController {

    public void startRace(){
        InputView inputView = new InputView();
        String carInput = inputView.inputCarNames();
        int tryInput = inputView.inputTryTo();

        List<Car> cars = Car.createCars(carInput);
        Car.randomMoves(cars, tryInput);
    }

}
