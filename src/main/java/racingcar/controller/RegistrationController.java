package racingcar.controller;

import java.util.List;
import java.util.function.Function;
import racingcar.domain.Input;
import racingcar.domain.Registration;
import racingcar.service.constant.ExpressionFormat;
import racingcar.service.input.InputService;
import racingcar.service.input.Validation;
import racingcar.view.UserInput;
import racingcar.view.constant.Request;

public class RegistrationController {

    private static RegistrationController instance;
    private final InputService inputService;

    private RegistrationController() {
        inputService = new InputService();
    }

    public static RegistrationController getInstance() {
        if (instance == null) {
            return new RegistrationController();
        }
        return instance;
    }

    private Input rawInput(String message) {
        String input = UserInput.request(message);
        return inputService.receive(input);
    }
}
