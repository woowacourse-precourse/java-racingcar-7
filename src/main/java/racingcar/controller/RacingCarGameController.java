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
        outputRacingCarView.printCarNameInputText();
        String racingCarNames = inputRacingCarView.getInputText();
        outputRacingCarView.printCarMoveCountInputText();
        int moveCount = inputRacingCarView.getInputNumber();

        RacingCarGameResult gameResult = racingCarGame.playRacingGame(racingCarNames, moveCount);

        outputRacingCarView.printGameResult(gameResult.getGameResult());
        outputRacingCarView.printGameWinners(gameResult.getGameWinnerNames());
    }
}
