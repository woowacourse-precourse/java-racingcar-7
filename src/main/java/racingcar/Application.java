package racingcar;

import racingcar.view.CarNameInputValidator;

public class Application {
    public static void main(String[] args) {
        CarNameInputValidator carNameInputValidator = new CarNameInputValidator();
        carNameInputValidator.getCarNames();
    }
}
