package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.validation.Validator;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private final RacingGameView view;
    private final Validator carNamesValidator;
    private final Validator attemptCountValidator;
    private final MoveStrategy moveStrategy;

    public RacingGameController(
        RacingGameView view,
        Validator carNamesValidator,
        Validator attemptCountValidator,
        MoveStrategy moveStrategy
    ) {
        this.view = view;
        this.carNamesValidator = carNamesValidator;
        this.attemptCountValidator = attemptCountValidator;
        this.moveStrategy = moveStrategy;
    }

    public void play() {
        List<String> racingCarNames = getRacingCarNames();
        int attemptCount = getAttemptCount();

        RacingCars racingCars = RacingCars.of(moveStrategy, racingCarNames);

        run(attemptCount, racingCars);

        winners(racingCars);
    }

    private void run(int attemptCount, RacingCars racingCars) {
        view.printRacingResultStart();
        while (attemptCount-- > 0) {
            racingCars.moveAll();
            view.printRacingResult(racingCars);
        }
    }

    private void winners(RacingCars racingCars) {
        view.printWinners(
            String.join(", ", racingCars.getWinners().stream()
                .map(RacingCar::getName)
                .toList()
            )
        );
    }

    private List<String> getRacingCarNames() {
        view.printCarNamesInputMessage();
        String carNames = view.getInput();

        carNamesValidator.validate(carNames);

        return Arrays.asList(carNames.split(","));
    }

    private int getAttemptCount() {
        view.printAttemptCountInputMessage();
        String attemptCount = view.getInput();

        attemptCountValidator.validate(attemptCount);

        return Integer.parseInt(attemptCount);
    }
}
