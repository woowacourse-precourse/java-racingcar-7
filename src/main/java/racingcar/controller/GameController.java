package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.domain.RacingGame;
import racingcar.domain.strategy.MoveStrategy;

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
        List<String> carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();

        RacingGame racingGame = new RacingGame(carNames, moveCount, moveStrategy);

        outputView.printMessage("\n실행 결과");
        while (racingGame.hasNextRound()) {
            racingGame.playNextRound();
            outputView.printRoundResult(racingGame.getCars());
        }
        List<Car> winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }
}
