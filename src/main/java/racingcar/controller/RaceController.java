package racingcar.controller;

import racingcar.config.RaceSetupFacade;
import racingcar.domain.*;
import racingcar.dto.MovementNumber;
import racingcar.dto.RaceResult;
import racingcar.util.RaceProgressFormatter;
import racingcar.util.WinnerFormatter;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private final List<RacingCar> cars;
    private final RaceProgressManager raceProgressManager;
    private final RandomNumberGenerator randomNumberGenerator;
    private final WinnerDecider winnerDecider;
    private final OutputView outputView;
    private final int attempts;
    private final RaceSetupFacade setupFacade;

    public RaceController(List<RacingCar> cars,
                          RaceProgressManager raceProgressManager,
                          RandomNumberGenerator randomNumberGenerator,
                          WinnerDecider winnerDecider,
                          OutputView outputView,
                          int attempts,
                          RaceSetupFacade setupFacade) {
        this.cars = cars;
        this.raceProgressManager = raceProgressManager;
        this.randomNumberGenerator = randomNumberGenerator;
        this.winnerDecider = winnerDecider;
        this.outputView = outputView;
        this.attempts = attempts;
        this.setupFacade = setupFacade;
    }

    public void startRace() {
        outputView.printExecutionResultPrompt();
        runAllRounds();
        determineAndPrintWinners();
    }

    private void runAllRounds() {
        for (int i = 0; i < attempts; i++) {
            runSingleRound();
        }
    }

    private void runSingleRound() {
        for (RacingCar car : cars) {
            MovementNumber movementNumber = randomNumberGenerator.movementNumber();
            MovementPolicy policy = setupFacade.createMovementPolicy(movementNumber);
            car.executeForward(policy, raceProgressManager);
        }
        RaceResult result = raceProgressManager.createRaceResult();
        List<String> roundVisualProgress = RaceProgressFormatter.toVisualProgress(result);
        outputView.printRoundProgress(roundVisualProgress);
    }

    private void determineAndPrintWinners() {
        RaceResult finalResult = raceProgressManager.createRaceResult();
        List<String> winners = winnerDecider.determineWinners(finalResult);

        String formattedWinners = WinnerFormatter.formatWinners(winners);
        outputView.printWinners(formattedWinners);
    }
}
