package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.List;

public class InputController {
    private InputView inputView = new InputView();
    private CarNameValidator carNameValidator = new CarNameValidator();
    private AttemptCountValidator attemptCountValidator = new AttemptCountValidator();

    public List<Car> initCars() {
        String carName = inputView.enterCarName();
        return carNameValidator.validate(carName);
    }

    public Integer initAttemptCount() {
        String attemtCount = inputView.enterAttemptCount();
        return attemptCountValidator.validate(attemtCount);
    }
}
