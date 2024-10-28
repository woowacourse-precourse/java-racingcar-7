package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.model.CarNameValidator;
import racingcar.model.GameRoundValidator;
import racingcar.view.InputView;

public class InputController {

    public static List<Car> setCarNames() {
        String carName = InputView.inputCarNames();
        return CarNameValidator.validate(carName);
    }

    public static int setGameRound() {
        String gameRound = InputView.inputRound();
        return GameRoundValidator.validate(gameRound);
    }
}
