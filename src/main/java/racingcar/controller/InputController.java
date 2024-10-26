package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.model.CarNameValidator;
import racingcar.model.GameCountValidator;
import racingcar.view.InputView;

public class InputController {

    public static List<Car> setCarNames() {
        String carName = InputView.inputCarNames();
        return CarNameValidator.validate(carName);
    }

    public static int setGameCount() {
        String gameCount = InputView.inputCount();
        return GameCountValidator.validate(gameCount);
    }
}
