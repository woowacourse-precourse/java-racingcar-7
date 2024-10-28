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
        RaceSetupFacade initializer = new RaceSetupFacade();

        outputView.printCarNameInputPrompt();
        List<String> carNames = inputView.readRacingCarNames().carNames();

        outputView.printNumberOfAttemptCountMessage();
        int attempts = inputView.readNumberOfAttemptCount().value();

        List<RacingCar> cars = initializer.initializeCars(carNames);

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
