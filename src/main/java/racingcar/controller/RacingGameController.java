package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingRegisterForm;
import racingcar.model.CarRace;
import racingcar.model.Cars;
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
        Cars cars = new Cars(carNames);
        CarRace carRace = new CarRace(cars, raceRoundCount);
        carRace.start();
    }
}
