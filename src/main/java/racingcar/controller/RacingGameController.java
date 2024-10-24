package racingcar.controller;

import java.util.List;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void start() {
        List<String> cars = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();
        racingGameService.inputMoveCount();
        racingGameService.race();
        outputView.announceWinners();
    }

    private void announceWinners() {
    }

    private void race() {
    }

    private void inputMoveCount() {
        
    }

    private void inputCars() {
        
    }


}
