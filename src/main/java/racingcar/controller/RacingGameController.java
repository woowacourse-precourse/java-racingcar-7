package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.RacingGameState;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.RacingGameCount;
import racingcar.view.input.RacingGameInput;
import racingcar.view.output.OutputView;

public class RacingGameController {
    private final RacingGameInput inputView;
    private final OutputView outputView;

    public RacingGameController(RacingGameInput inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        RacingGame game = createGame();
        playAndDisplayGame(game);
    }

    private RacingGame createGame() {
        String carNames = inputView.readInput();
        String tryCount = inputView.readTryCountInput();

        Cars cars = Cars.createCarsFrom(carNames);
        RacingGameCount racingCount = new RacingGameCount(tryCount);

        return new RacingGame(cars, racingCount);
    }

    private void playAndDisplayGame(RacingGame game) {
        checkFinishedGame(game);

        RacingGameState finalState = game.getGameState();
        outputView.printGameResult(finalState.getWinners());
    }

    private void checkFinishedGame(RacingGame game) {
        while (!game.isGameFinished()) {
            game.playOneRound();
            RacingGameState roundState = game.getGameState();
            outputView.printRoundResult(roundState.getRoundResults());
        }
    }
}
