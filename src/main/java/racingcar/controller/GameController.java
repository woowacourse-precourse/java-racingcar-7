package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
    private final InputView inputView;
    private final ResultView resultView;

    public GameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }


}
