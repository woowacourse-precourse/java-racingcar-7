package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.RacingGameState;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.RacingGameCount;
import racingcar.domain.movement.MovementStrategy;
import racingcar.view.input.RacingGameInput;
import racingcar.view.output.OutputView;

public class RacingGameController {
    private final RacingGameInput inputView;
    private final OutputView outputView;
    private final MovementStrategy moveStrategy;

    public RacingGameController(
            RacingGameInput inputView,
            OutputView outputView,
            MovementStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        RacingGame game = createGame();
        playAndDisplayGame(game);
    }

    private RacingGame createGame() {
        String carNames = inputView.readInput();
        String tryCount = inputView.readTryCountInput();

        Cars cars = Cars.createCarsFrom(carNames, moveStrategy);
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
            playAndDisplayRound(game);
        }
    }

    private void playAndDisplayRound(RacingGame game) {
        game.playOneRound();
        displayRoundState(game.getGameState());
    }

    private void displayRoundState(RacingGameState state) {
        outputView.printRoundResult(state.getRoundResults());
    }
}
