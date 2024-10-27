package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TestCar;

import java.util.List;
import java.util.stream.Collectors;

public class TestRacingController extends RacingController {
    public TestRacingController() {
        super();
    }

    @Override
    public Cars initializeCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(i -> new TestCar(i, true))
                .collect(Collectors.toList()));
    }
}