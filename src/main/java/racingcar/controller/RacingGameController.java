package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            RacingGame racingGame = createGame();
            playGame(racingGame);
            announceWinners(racingGame);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private RacingGame createGame() {
        String[] carNames = inputView.readCarNames();
        int rounds = inputView.readRounds();
        return new RacingGame(carNames, rounds);
    }

    private void playGame(RacingGame racingGame) {
        outputView.printGameStart();
        while (!racingGame.isGameFinished()) {
            racingGame.playOneRound();
            outputView.printRoundResult(racingGame.getCars());
        }
    }

    private void announceWinners(RacingGame racingGame) {
        outputView.printWinners(racingGame.getWinners());
    }
}