package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.List;

public class InputController {
    InputView inputView = new InputView();
    CarNameValidator carNameValidator = new CarNameValidator();
    public List<Car> initCars() {
        String carName = inputView.enterCarName();
        return carNameValidator.validate(carName);
    }
}
