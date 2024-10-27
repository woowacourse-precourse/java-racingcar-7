package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingSetUp {
    private final String carNames;
    private final Long tryCount;
    private final Cars cars;

    public RacingSetUp() {
        carNames = setUpCarNames();
        tryCount = setUpTryCount();
        cars = registerCars();
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
        } finally {
            Console.close();
        }

        return tryCount;
    }

    public Cars registerCars() {
        return CarFactory.getInstance().createCars(carNames);
    }

    public Long getTryCount() {
        return tryCount;
    }

    public Cars getCars() {
        return cars;
    }

}
