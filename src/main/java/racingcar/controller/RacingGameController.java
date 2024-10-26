package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingRegisterForm;
import racingcar.dto.RoundRaceRecord;
import racingcar.model.CarRace;
import racingcar.model.Cars;
import racingcar.model.RegistrarClerk;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startRace() {
        RacingRegisterForm registerForm = getRacingRegisterForm();
        Cars cars = getCars(registerForm);
        int raceRoundCount = registerForm.raceRoundCount();
        CarRace carRace = new CarRace(cars);
        outputView.printRaceStart();
        for (int i = 1; i <= raceRoundCount; i++) {
            List<RoundRaceRecord> roundResult = carRace.startRound();
            outputView.printRoundResult(roundResult);
        }
        displayWinners(carRace);
    }

    private RacingRegisterForm getRacingRegisterForm() {
        String inputCarNames = inputView.requestCarNames();
        String inputRaceRoundCount = inputView.requestRaceRoundCount();
        RegistrarClerk registrarClerk = new RegistrarClerk();
        return registrarClerk.register(inputCarNames, inputRaceRoundCount);
    }

    private Cars getCars(RacingRegisterForm registerForm) {
        List<String> carNames = registerForm.carNames();
        return new Cars(carNames);
    }

    private void displayWinners(CarRace carRace) {
        List<String> winnerCarNames = carRace.getWinnerCarNames();
        outputView.printWinner(winnerCarNames);
    }
}
