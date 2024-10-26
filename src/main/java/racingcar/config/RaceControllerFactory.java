package racingcar.config;

import racingcar.controller.RaceController;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceControllerFactory {

    public static RaceController createRaceController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RaceSetupFacade initializer = new RaceSetupFacade(inputView, outputView);

        List<RacingCar> cars = initializer.initializeCars();
        int attempts = initializer.initializeAttemptCount();

        return new RaceController(
                cars,
                initializer.createRaceProgressManager(cars),
                initializer.createRandomNumberGenerator(),
                initializer.createWinnerDecider(),
                outputView,
                attempts,
                initializer
        );
    }
}


