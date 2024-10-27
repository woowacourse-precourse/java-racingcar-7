package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.Util;
import racingcar.validator.Validator;
import racingcar.view.InputView;

public class Controller {
    InputView inputView = new InputView();
    Validator validator = new Validator();

    public void run() {
        List<Car> cars = readyCar();
    }

    private List<Car> readyCar() {
        String string = inputView.input();
        validator.validateNames(string);
        List<Car> cars = new ArrayList<>();
        for (String name : Util.splitByComma(string)) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
