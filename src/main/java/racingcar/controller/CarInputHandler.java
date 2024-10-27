package racingcar.controller;

import racingcar.model.Car;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CarInputHandler {
    public List<Car> getCarNames() {
        String carNames = InputView.inputCarNames();
        CarNameValidator.validateCarNames(carNames);

        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}
