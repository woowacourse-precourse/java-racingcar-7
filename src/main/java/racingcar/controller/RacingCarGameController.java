package racingcar.controller;

import racingcar.domain.RacingCarGameResult;
import racingcar.service.RacingCarGame;
import racingcar.view.InputRacingCarView;
import racingcar.view.OutputRacingCarView;

public class RacingCarGameController {
    private final RacingCarGame racingCarGame;
    private final InputRacingCarView inputRacingCarView;
    private final OutputRacingCarView outputRacingCarView;

    public RacingCarGameController(RacingCarGame racingCarGame) {
        this.racingCarGame = racingCarGame;
        this.inputRacingCarView = new InputRacingCarView();
        this.outputRacingCarView = new OutputRacingCarView();
    }

    public void run() {
        String racingCarNames = inputRacingCarView.inputCarName();
        int moveCount = Integer.parseInt(inputRacingCarView.inputCarMoveCount());

        RacingCarGameResult gameResult = racingCarGame.playRacingGame(racingCarNames, moveCount);

        outputRacingCarView.outputGameResult(gameResult.getGameResult());
        outputRacingCarView.outputGameWinners(gameResult.getGameWinnerNames());
    }
}
