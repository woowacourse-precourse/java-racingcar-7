package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private String carNames = "";
    private int roundCount = 0;

    public void start() {
        OutputView.printInputNamesMessage();

        carNames = InputView.readInput();

        OutputView.printInputRoundMessage();

        String round = InputView.readInput();
        roundCount = Integer.parseInt(round);

        Game game = new Game(carNames);
        run(game);
    }

    public void run(Game game) {
        OutputView.printFinalResultMessage();
    }
}
