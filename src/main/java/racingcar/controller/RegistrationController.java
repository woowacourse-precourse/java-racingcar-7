package racingcar.controller;

import racingcar.domain.Registration;
import racingcar.service.input.RegistrationService;

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
