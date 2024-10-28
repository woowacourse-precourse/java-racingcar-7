package racingcar.controller;

import racingcar.domain.Registration;
import racingcar.service.input.RegistrationService;

public class RegistrationController {

    private static RegistrationController instance;
    private final RegistrationService registrationService;

    private RegistrationController() {
        this.registrationService = new RegistrationService();
    }

    public Registration register() {
        return registrationService.register();
    }

    public static RegistrationController getInstance() {
        if (instance == null) {
            instance = new RegistrationController();
        }
        return instance;
    }
}
