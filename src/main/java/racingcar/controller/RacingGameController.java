package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.service.CarSetupService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService;
    private final InputView inputView;
    private final OutputView outputView;
    private final CarSetupService carSetupService;

    public RacingGameController(
            RacingGameService racingGameService,
            InputView inputView,
            OutputView outputView,
            CarSetupService carSetupService) {
        this.racingGameService = racingGameService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.carSetupService = carSetupService;
    }

    public void run() {
        outputView.displayCarNameInput();
        String inputValue = inputView.inputCarNames();
        List<Car> CarNames = carSetupService.parseCarNames(inputValue);

        outputView.displayAttemptCount();
        int count = carSetupService.parseAttemptCount(inputView.inputAttemptCount());
    }


}
