package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {

    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.inputView = new InputView();
        this.racingCarService = new RacingCarService();
    }

    public void run() {
        inputView.printInputCarNameMessage();
        String carNameInput = inputView.getInput();
        racingCarService.checkCarNamesInput(carNameInput);

        inputView.printInputTryCountMessage();
        String tryCountInput = inputView.getInput();
    }
}
