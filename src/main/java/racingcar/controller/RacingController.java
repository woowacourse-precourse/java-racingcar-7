package racingcar.controller;

import racingcar.service.RacingRound;
import racingcar.view.ConsoleMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final OutputView outputView = new OutputView();
    private RacingRound racingRound;

    public RacingController() {
        InputView inputView = new InputView();
        racingRound = new RacingRound(inputView.getCarList());
        start(inputView.getTryNumber());

    }

    private void start(long tryNumber) {
        System.out.println(ConsoleMessage.ROUND_RESULT);
        while (tryNumber > 0) {
            racingRound.moveForward();
            outputView.printRoundOutput(racingRound.getCarToRacingProgress());
            tryNumber--;
        }
        outputView.printFinalWinner(racingRound.getWinner());
    }


}
