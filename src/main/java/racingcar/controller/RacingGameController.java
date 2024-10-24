package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingRegisterForm;
import racingcar.service.RegistrationService;

public class RacingGameController {

    private final RegistrationService registrationService;

    public RacingGameController() {
        registrationService = new RegistrationService();
    }

    public void start() {
        RacingRegisterForm registerForm = registrationService.register();
        List<String> carNames = registerForm.carNames();
        int raceRoundCount = registerForm.raceRoundCount();
    }
}
