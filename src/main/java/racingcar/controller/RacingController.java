package racingcar.controller;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final OutputView outputView;
    private final InputView inputView;

    public RacingController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        var carNames = getCarNames();
        var round = getRound();
    }

    private void playGame(List<String> carNames, int round) {
        var racingGame = new RacingGame(round);
        racingGame.addCar(carNames);

        while (isGmeProcessing(racingGame)) {
            var roundInfo = racingGame.playRound();
            outputView.printRoundResult(roundInfo);
        }

        var winnerNames = racingGame.getWinnerNames();
        outputView.printWinner(winnerNames);
    }

    private List<String> getCarNames() {
        outputView.printRequestCarNames();
        var carNames = inputView.readLine();
        return InputParser.parseName(carNames);
    }

    private int getRound() {
        outputView.printRequestRound();
        var round = inputView.readLine();
        return InputParser.parseRound(round);
    }

    private boolean isGmeProcessing(RacingGame racingGame) {
        return !racingGame.isEnd();
    }
}
