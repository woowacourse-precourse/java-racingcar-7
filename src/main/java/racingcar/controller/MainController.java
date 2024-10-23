package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.CarsRegistrar;
import racingcar.view.Input;

public class MainController {

    public void run() {
        Cars cars = createCars();


    }

    private Cars createCars() {
        CarsRegistrar carsRegistrar = new CarsRegistrar();
        return carsRegistrar.registerCars(inputCarNames());
    }

    private String inputCarNames() {
        return Input.inputCarNames();
    }

}
