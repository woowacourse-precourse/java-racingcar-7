package racingcar;

import racingcar.validators.CarInputValidator;
import racingcar.validators.RoundInputValidator;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        String carInput = view.getCarInput();

        CarInputValidator carInputValidator = new CarInputValidator();
        carInputValidator.validate(carInput);

        String roundInput = view.getRoundInput();

        RoundInputValidator roundInputValidator = new RoundInputValidator();
        roundInputValidator.validate(roundInput);
    }
}
