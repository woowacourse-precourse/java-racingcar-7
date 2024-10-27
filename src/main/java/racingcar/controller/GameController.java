package racingcar.controller;

import racingcar.constant.MovementCondition;
import racingcar.model.GameManager;
import racingcar.model.GameStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        GameManager gameManager = GameManager.from(inputView.inputCarNames());
        GameStatus gameStatus = GameStatus.of(inputView.inputAttempts(), gameManager.getRacers());

        outputView.printResultMessage();
        moveForwardCars(gameManager, gameStatus);

        outputView.printWinners(gameManager.findWinners(gameStatus));
    }

    private void moveForwardCars(GameManager gameManager, GameStatus gameStatus) {
        while (!gameStatus.isEnd()) {
            gameStatus.attempt();

            gameManager.getRacers().forEach(racer -> {
                MovementCondition movementCondition = racer.decideToMove(
                        gameManager.generateRandomNumberForMoveForward());
                gameStatus.updateRacerByMovementCondition(racer, movementCondition);
            });

            outputView.printMovementStates(gameManager.getCurrentMovementStates(gameStatus));
        }
    }

}
