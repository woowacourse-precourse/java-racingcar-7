package racingcar.config;

import racingcar.domain.RaceProgressManager;
import racingcar.domain.RacingCar;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.WinnerDecider;
import racingcar.domain.MovementPolicy;
import racingcar.dto.AttemptCount;
import racingcar.dto.MovementNumber;
import racingcar.dto.RacingCarNames;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceSetupFacade {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceSetupFacade(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<RacingCar> initializeCars() {
        outputView.printCarNameInputPrompt();
        RacingCarNames carNames = inputView.readRacingCarNames();
        return carNames.carNames().stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public int initializeAttemptCount() {
        outputView.printNumberOfAttemptCountMessage();
        AttemptCount attemptCount = inputView.readNumberOfAttemptCount();
        return attemptCount.value();
    }

    public RaceProgressManager createRaceProgressManager(List<RacingCar> cars) {
        return new RaceProgressManager(cars);
    }

    public RandomNumberGenerator createRandomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public WinnerDecider createWinnerDecider() {
        return new WinnerDecider();
    }

    public MovementPolicy createMovementPolicy(MovementNumber movementNumber) {
        return new MovementPolicy(movementNumber);
    }
}
