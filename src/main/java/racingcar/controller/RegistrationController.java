package racingcar.controller;

import java.util.List;
import java.util.function.Function;
import racingcar.domain.Input;
import racingcar.domain.Race;
import racingcar.domain.Registration;
import racingcar.repository.InputRepository;
import racingcar.service.constant.ExpressionFormat;
import racingcar.service.input.InputService;
import racingcar.service.input.RegistrationService;
import racingcar.service.input.Validation;
import racingcar.service.race.RaceStarterService;
import racingcar.view.UserInput;
import racingcar.view.constant.Request;

public class RegistrationController {

    private static RegistrationController instance;
    private RegistrationService registrationService;

    private RegistrationController() {
        this.registrationService = new RegistrationService();
    }

    public Registration register() {
        return registrationService.register();
    }

    public static RegistrationController getInstance() {
        if (instance == null) {
            return new RegistrationController();
        }
        return instance;
    }
}
