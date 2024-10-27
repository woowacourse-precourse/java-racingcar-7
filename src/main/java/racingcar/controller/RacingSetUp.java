package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingSetUp {
    private final String carNames;
    private final Long tryCount;
    private final Cars cars;

    public RacingSetUp() {
        this.carNames = setUpCarNames();
        this.tryCount = setUpTryCount();
        this.cars = registerCars();
    }

    private String setUpCarNames() {
        return InputView.inputCarNames();
    }

    private Long setUpTryCount() {
        String textTryCount = InputView.inputTryCount();
        return toLong(textTryCount);
    }

    private Long toLong(String textTryCount) {
        long tryCount;

        try {
            tryCount = Long.parseLong(textTryCount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("시도 횟수는 아라비아 숫자로 입력해야 합니다");
        }

        return tryCount;
    }

    private Cars registerCars() {
        return CarFactory.getInstance().createCars(carNames);
    }

    public Long getTryCount() {
        return tryCount;
    }

    public Cars getCars() {
        return cars;
    }
}
