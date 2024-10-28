package racingcar.controller;

import java.util.List;
import java.util.function.Function;
import racingcar.domain.Input;
import racingcar.service.constant.ExpressionFormat;
import racingcar.service.input.InputService;
import racingcar.view.UserInput;

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

    private String validatedInput(Input userInput, Function<String, String> validation) {
        return validation.apply(userInput.getInput());
    }

    private List<String> lineupSetting(String carNames) {
        return List.of(carNames.split(ExpressionFormat.SEPARATOR.form()));
    }
}
