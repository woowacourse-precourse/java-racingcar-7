package racingcar.controller;

import java.util.List;
import racingcar.model.RaceGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
    InputView inputView;
    OutputView outputView;
    RandomNumberGenerator randomNumberGenerator;

    public RaceGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    private void playGame(RaceGame game) {
        for (int i = 0; i < game.getAttempts(); i++) {
            game.moveAll(randomNumberGenerator);
            outputView.printRoundResult(game.getCars());
        }
        outputView.printWinners(game.getWinners());
    }

    public void run(){
        outputView.printGameStart();
        List<String> carNames = inputView.readCarNames();

        outputView.printAttemptPrompt();
        int attempts = inputView.readAttempts();

        RaceGame game = new RaceGame(carNames, attempts);
        playGame(game);
    }
}
