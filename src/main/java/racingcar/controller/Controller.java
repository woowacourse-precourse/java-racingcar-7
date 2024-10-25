package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    public List<Car> inputCarNameToList(){

        return InputView.inputCarName()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
