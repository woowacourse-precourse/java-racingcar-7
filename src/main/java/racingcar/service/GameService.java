package racingcar.service;

import racingcar.domain.Game;
import racingcar.view.OutputView;

public class GameService {
    private final Game game;
    private final OutputView outputView;

    public GameService(final Game game, final OutputView outputView) {
        this.game = game;
        this.outputView = outputView;
    }

    public void gameStart(final int tryCount) {
        outputView.printBeforeMessage();
        for (int i = 0; i < tryCount; i++) {
            game.playOneRound();
            outputView.printOneRoundResult(game.getCarList());
        }
    }

    public void announceTheWinners() {
        String winnerNames = game.getWinners();
        outputView.printWinners(winnerNames);
    }
}
