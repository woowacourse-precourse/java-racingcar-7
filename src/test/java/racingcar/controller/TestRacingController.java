package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TestCar;

import java.util.List;
import java.util.stream.Collectors;

public class TestRacingController extends RacingController {
    private final List<String> carNames;
    private final int moveCount;

    public TestRacingController(List<String> carNames, int moveCount) {
        super();
        this.carNames = carNames;
        this.moveCount = moveCount;
    }

    @Override
    protected Cars initializeCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(i -> new TestCar(i, true))
                .collect(Collectors.toList()));
    }

    @Override
    protected List<String> readCarNames() {
        return carNames;
    }

    @Override
    protected int readMoveCount() {
        return moveCount;
    }

}