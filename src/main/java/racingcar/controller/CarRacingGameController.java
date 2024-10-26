package racingcar.controller;

import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.service.CarRacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGameController {

    private final CarRacingGameService carRacingGameService;

    public CarRacingGameController() {
        this.carRacingGameService = new CarRacingGameService();
    }

    public void start() {
        OutputView.printSetCarNameMessage();
        CarNameRequest carNameRequest = InputView.getCarName();

        OutputView.printSetTryNumberMessage();
        TryNumberRequest tryNumberRequest = InputView.getTryNumber();

        carRacingGameService.startRacing(carNameRequest, tryNumberRequest);
    }

}
