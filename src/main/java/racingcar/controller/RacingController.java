package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.ConsoleMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingService = new RacingService(inputView.getCarList());

        start(inputView.getTryNumber());
        end();
    }

    private void start(long tryNumber) {
        System.out.println(ConsoleMessage.ROUND_RESULT);

        while (tryNumber > 0) {
            racingService.moveForward();
            outputView.printRoundOutput(racingService.getCarToRacingProgress());
            tryNumber--;
        }

        outputView.printFinalWinner(racingService.getWinner());
    }

    private void end() {
        inputView.close();
    }
}
