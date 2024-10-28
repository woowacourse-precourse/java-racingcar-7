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
        try {
            return Integer.parseInt(StartView.inputNumOfMatch());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해 주세요.", e);
        }
    }
}
