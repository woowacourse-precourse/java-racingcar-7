package racingcar.racing.controller;

import racingcar.racing.model.RacingGameConcreteFactory;
import racingcar.racing.view.InputView;
import racingcar.racing.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameConcreteFactory racingGameFactory;

    public RacingGameController(InputView inputView, OutputView outputView,
                                RacingGameConcreteFactory racingGameFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameFactory = racingGameFactory;
    }
}
