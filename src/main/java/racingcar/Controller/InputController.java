package racingcar.Controller;

import racingcar.Model.GameCars;
import racingcar.Validation.InputValidator;
import racingcar.View.StartView;

public class InputController {


    public static GameCars setCars() {
        String carInput = StartView.inputCarInfo();
        validateInput(carInput);
        String[] carNames = carInput.split(",");
        return new GameCars(carNames);
    }

    private static void validateInput(String carInput) {
        InputValidator.validate(carInput);
    }


    public static int setGameCount() {
        return Integer.parseInt(StartView.inputNumOfMatch());
    }
}