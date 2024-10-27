package racingcar.controller;

import racingcar.model.MoveStrategy;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final MoveStrategy moveStrategy;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(MoveStrategy moveStrategy, InputView inputView, OutputView outputView) {
        this.moveStrategy = moveStrategy;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = inputView.getCarNames();
        int raceCount = inputView.getRaceCount();
        RacingGame racingGame = new RacingGame(carNames);

        outputView.printStartMessage();

        for (int i = 0; i < raceCount; i++) {
            racingGame.playRound(moveStrategy);
            outputView.printRoundResult(racingGame.getCars());
        }

        outputView.printWinners(racingGame.getWinners());
    }
}
