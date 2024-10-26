package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingRegisterForm;
import racingcar.model.CarRace;
import racingcar.model.Cars;
import racingcar.service.RegistrationService;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RegistrationService registrationService;
    private final OutputView outputView;

    public RacingGameController() {
        registrationService = new RegistrationService();
        outputView = new OutputView();
    }

    public void start() {
        CarRace carRace = createCarRaceFromInput();
        carRace.start();
        displayWinners(carRace);
    }

    private CarRace createCarRaceFromInput() {
        RacingRegisterForm registerForm = registrationService.register();
        List<String> carNames = registerForm.carNames();
        int raceRoundCount = registerForm.raceRoundCount();
        Cars cars = new Cars(carNames);
        return new CarRace(cars, raceRoundCount);
    }

    private void displayWinners(CarRace carRace) {
        List<String> winnerCarNames = carRace.getWinnerCarNames();
        outputView.printWinner(winnerCarNames);
    }
}
