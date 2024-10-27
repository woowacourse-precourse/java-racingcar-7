package racingcar.controller;

import racingcar.common.InputValidator;
import racingcar.service.RacingGameService;
import racingcar.util.Separator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.Car;
import racingcar.vo.CarFactory;

import java.util.Set;

public class RacingGameController {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final Separator separator;
    private final CarFactory carFactory;
    private final RacingGameService racingGameService;
    private final OutputView outputView;

    public RacingGameController(InputView inputView,
                                InputValidator inputValidator,
                                Separator separator,
                                CarFactory carFactory,
                                RacingGameService racingGameService, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.separator = separator;
        this.carFactory = carFactory;
        this.racingGameService = racingGameService;
        this.outputView = outputView;
    }

    public void run() {
        Set<Car> cars = initializeCars();
        int round = inputValidator.validateAttemptCount(inputView.getGameAttempt());
        startRaceAndPrintCarsPosition(round, cars);
    }

    private void startRaceAndPrintCarsPosition(int round, Set<Car> cars) {
        outputView.printResultMessage();
        for (int i = 0; i < round; i++) {
            racingGameService.moveCars(cars);
            outputView.printCarsPosition(cars);
        }
    }

    private Set<Car> initializeCars() {
        String[] carNames = separator.splitWithComma(inputView.getCarNames());
        inputValidator.validateCarNamesAndNumberOfCars(carNames);
        return carFactory.createCars(carNames);
    }

}
