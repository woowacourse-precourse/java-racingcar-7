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

    public Registration register() {
        String carsInput = validatedInput(rawInput(Request.CAR_NAMES.toString())
                , Validation::carNames);
        String lapInput = validatedInput(rawInput(Request.ATTEMPT_NUMBER.toString())
                , Validation::lapCount);

        return new Registration(lineupSetting(carsInput), lapCountSetting(lapInput));
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

    private Long lapCountSetting(String count) {
        return Long.parseLong(count);
    }
}
