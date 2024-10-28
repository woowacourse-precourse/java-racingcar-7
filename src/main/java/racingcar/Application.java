package racingcar;

import racingcar.controller.Controller;
import racingcar.model.CarRace;
import racingcar.service.validation.AttemptNumberValidator;
import racingcar.service.validation.InputValidator;
import racingcar.service.validation.NameValidator;
import racingcar.model.InputParser;
import racingcar.service.Service;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: Factory or 다른 방법 있는지?
        InputParser inputParser = new InputParser();
        InputValidator<List<String>> nameValidator = new NameValidator();
        InputValidator<String> attemptValidator = new AttemptNumberValidator();
        CarRace carRace = new CarRace();
        Service service = new Service(carRace);
        Controller controller = new Controller(inputParser, nameValidator, attemptValidator, service);
        controller.run();
    }
}