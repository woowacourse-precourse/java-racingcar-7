package racingcar.controller;

import java.util.List;
import racingcar.converter.Converter;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Race;
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

        Race race = Race.from(cars, tryCount);
        race.start();
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
