package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingRegisterForm;
import racingcar.dto.RoundRaceRecord;
import racingcar.model.CarRace;
import racingcar.model.CarRaceRoundManager;
import racingcar.model.RacingRegisterFormFactory;
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
        CarRace carRace = createCarRace(registerForm);
        CarRaceRoundManager roundManager = createCarRaceRoundManager(registerForm);

        outputView.printRaceStart();
        while (roundManager.hasMoreRounds()) {
            executeRaceRound(carRace, roundManager);
        }
        displayWinners(carRace);
    }

    private RacingRegisterForm getRacingRegisterForm() {
        String inputCarNames = inputView.requestCarNames();
        String inputRaceRoundCount = inputView.requestRaceRoundCount();
        return RacingRegisterFormFactory.create(inputCarNames, inputRaceRoundCount);
    }

    private CarRace createCarRace(RacingRegisterForm registerForm) {
        return new RegistrarClerk().register(registerForm);
    }

    private CarRaceRoundManager createCarRaceRoundManager(RacingRegisterForm registerForm) {
        return new CarRaceRoundManager(registerForm.raceRoundCount());
    }

    private void executeRaceRound(CarRace carRace, CarRaceRoundManager roundManager) {
        List<RoundRaceRecord> roundResult = carRace.startRound();
        outputView.printRoundResult(roundResult);
        roundManager.nextRound();
    }

    private void displayWinners(CarRace carRace) {
        List<String> winnerCarNames = carRace.getWinnerCarNames();
        outputView.printWinner(winnerCarNames);
    }
}
