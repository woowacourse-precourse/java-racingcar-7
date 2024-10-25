package racingcar;

import racingcar.controller.GameController;
import racingcar.model.car.CarRepository;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialValidator;
import racingcar.validator.Validator;

public class Application {
    public static void main(String[] args) {

        Validator<String[]> nameValidator = new CarNameValidator();
        Validator<String> trialValidator = new TrialValidator();
        CarRepository carRepository = new CarRepository();
        GameController gameController = new GameController(nameValidator, trialValidator, carRepository);
        gameController.run();
    }
}
