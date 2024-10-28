package racingcar.controller;

import racingcar.model.GameResult;
import racingcar.service.RacingGamePresenter;
import racingcar.service.RacingGame;

public class RacingGameController {
    private final RacingGame racingGame;
    private final RacingGamePresenter presenter;

    public RacingGameController(RacingGame racingGame, RacingGamePresenter presenter) {
        this.racingGame = racingGame;
        this.presenter = presenter;
    }

    public String playGame() {
        GameResult result = racingGame.play();
        return presenter.presentGameResult(result);
    }
}
