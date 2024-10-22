package racingcar;

import racingcar.validators.CarInputValidator;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        String carInput = view.getCarInput();

        CarInputValidator carInputValidator = new CarInputValidator();
        carInputValidator.validate(carInput);
    }
}
