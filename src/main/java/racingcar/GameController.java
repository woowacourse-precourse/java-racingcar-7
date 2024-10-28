package racingcar;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MoveStrategy moveStrategy;

    public GameController(InputView inputView, OutputView outputView,
                          MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        try {
            List<String> carNames = inputView.getCarNames();
            int moveCount = inputView.getMoveCount();

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
