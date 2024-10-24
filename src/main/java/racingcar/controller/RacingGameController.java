package racingcar.controller;

import racingcar.common.InputValidator;
import racingcar.service.RacingGameService;
import racingcar.util.Separator;
import racingcar.view.InputView;
import racingcar.vo.Car;
import racingcar.vo.CarFactory;

import java.util.Set;

public class RacingGameController {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final Separator separator;
    private final CarFactory carFactory;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView,
                                InputValidator inputValidator,
                                Separator separator,
                                CarFactory carFactory,
                                RacingGameService racingGameService) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.separator = separator;
        this.carFactory = carFactory;
        this.racingGameService = racingGameService;
    }

    public void run() {
        Set<Car> cars = initializeCars();
        int attemptCount = inputValidator.validateAttemptCount(inputView.getGameAttempt());
        racingGameService.startGame(cars, attemptCount);
    }

    private Set<Car> initializeCars() {
        String[] carNames = separator.splitWithComma(inputView.getCarNames());
        inputValidator.validateCarNamesAndNumberOfCars(carNames);
        return carFactory.createCars(carNames);
    }

}
