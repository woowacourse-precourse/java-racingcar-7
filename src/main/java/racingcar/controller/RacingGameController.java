package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.RaceRegistrationForm;
import racingcar.dto.RoundRaceRecord;
import racingcar.model.race.CarRace;
import racingcar.model.race.CarRaceRoundManager;
import racingcar.model.registration.RaceRegistrationFormFactory;
import racingcar.model.race.strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MoveStrategy moveStrategy;

    public RacingGameController(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        RaceRegistrationForm registerForm = createRegisterFormFromInput();
        CarRace carRace = createCarRace(registerForm);
        CarRaceRoundManager roundManager = createCarRaceRoundManager(registerForm);

        outputView.printRaceStart();
        while (roundManager.hasMoreRounds()) {
            executeRaceRound(carRace, roundManager);
        }
        displayWinners(carRace);

        releaseResources();
    }

    private RaceRegistrationForm createRegisterFormFromInput() {
        String inputCarNames = inputView.requestCarNames();
        String inputRaceRoundCount = inputView.requestRaceRoundCount();
        return RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount);
    }

    private CarRace createCarRace(RaceRegistrationForm registerForm) {
        return CarRace.create(registerForm, moveStrategy);
    }

    private CarRaceRoundManager createCarRaceRoundManager(RaceRegistrationForm registerForm) {
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

    private void releaseResources() {
        Console.close();
    }
}
