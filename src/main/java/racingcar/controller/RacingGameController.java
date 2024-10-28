package racingcar.controller;


import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGameController {

    private List<Car> initializeCars() {
        List<Car> cars = new ArrayList<>();
        Set<String> unique = new HashSet<>();
        for (String name : InputView.getInputCar()) {
            if (!unique.add(name)) {
                throw new IllegalArgumentException("이름이 중복됩니다.");
            }
            cars.add(new Car(name));
        }
        return cars;
    }

}
