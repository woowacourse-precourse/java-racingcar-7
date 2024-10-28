package racingcar.controller;

import domain.car.Car;
import domain.car.CarFactory;
import domain.car.Cars;
import java.util.List;
import racingcar.converter.Converter;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final Converter<String, Integer> converter;

    public RacingController(Converter<String, Integer> converter) {
        this.converter = converter;
    }

    public void startGame() {
        Cars cars = createCars();
        int tryCount = getTryCount();
    }

    private Cars createCars() {
        String carNames = getCarNames();
        List<Car> carList = CarFactory.createCars(carNames);
        return Cars.from(carList);
    }

    private static String getCarNames() {
        OutputView.showCarNameInputMessage();
        return InputView.inputCarNames();
    }

    private int getTryCount() {
        OutputView.showTryCountInputMessage();
        String input = InputView.inputTryCount();

        int tryCount = converter.convert(input);
        TryCountValidator.validatePositiveInteger(tryCount);
        return tryCount;
    }
}
