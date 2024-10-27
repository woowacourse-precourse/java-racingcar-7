package racingcar.game;

import racingcar.view.OutputHandler;

public class RacingGameController {
    private final RacingGame racingGame;
    private final OutputHandler outputHandler;

    public RacingGameController(RacingGame racingGame, OutputHandler outputHandler) {
        this.racingGame = racingGame;
        this.outputHandler = outputHandler;
    }

    public void startGame() {
        while (racingGame.hasNextRound()) {
            racingGame.playOneRound();
            outputHandler.printStatus(racingGame.getCars());
        }

        outputHandler.printWinner(racingGame.getWinners());
    }
}
