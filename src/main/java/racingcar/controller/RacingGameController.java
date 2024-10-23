package racingcar.controller;

import racingcar.common.InputValidator;
import racingcar.util.Separator;
import racingcar.view.InputView;
import racingcar.vo.Car;
import racingcar.vo.CarFactory;

import java.util.Set;

public class RacingGameController {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final Separator separator;
    private final CarFactory carFactory;

    public RacingGameController(InputView inputView, InputValidator inputValidator, Separator separator, CarFactory carFactory) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.separator = separator;
        this.carFactory = carFactory;
    }

    public void run() {
        gameSetting();
    }

    private void gameSetting() {
        String[] carNames = separator.splitWithComma(inputView.getCarNames());
        inputValidator.validateCarNamesAndNumberOfCars(carNames);
        Set<Car> cars = carFactory.createCars(carNames);
        int attemptCount = inputValidator.validateAttemptCount(inputView.getGameAttempt());
    }

}
