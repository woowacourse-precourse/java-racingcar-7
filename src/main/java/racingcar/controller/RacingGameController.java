package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;
import java.util.List;

public class RacingGameController {
    private RacingGameView view;
    private RacingGame game;

    public RacingGameController() {
        this.view = new RacingGameView();
    }

    public void start() {
        List<String> carNames = view.getCarNames();
        int round = view.getRound();

        game = new RacingGame(carNames, round);
        playGame();
    }

    public void playGame() {
        for (int i = 0; i < game.getRound(); i++) {
            game.race();
            view.printStatus(game.getCars());
        }
        view.printWinner(game.getWinners());
    }
}
