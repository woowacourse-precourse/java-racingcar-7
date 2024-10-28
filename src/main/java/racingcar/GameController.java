package racingcar;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        try {
            List<String> carNames = inputView.getCarNames();
            int moveCount = inputView.getMoveCount();

            MoveStrategy moveStrategy = new RandomMoveStrategy(
                    new DefaultRandomGenerator());
            RacingGame racingGame = new RacingGame(
                    carNames, moveCount, moveStrategy);

            outputView.printMessage("\n실행 결과");
            while (racingGame.hasNextRound()) {
                racingGame.playNextRound();
                outputView.printRoundResult(racingGame.getCars());
            }
            List<Car> winners = racingGame.getWinners();
            outputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            throw e;
        }
    }
}
