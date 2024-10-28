package racingcar.presentation.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.service.car.RacingCarService;
import racingcar.presentation.ui.InputView;
import racingcar.presentation.ui.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingCarService = new RacingCarService();
    }

    public void run() {
        inputView.inputCarNameUi();
        racingCarService.inputCarName(Console.readLine());
        inputView.inputTryUi();
        racingCarService.inputTryNumber(Console.readLine());
        racingCarService.startGame();
        outputView.outputRacingResultUi();
        outputView.outputWinnerUi();
    }
}
