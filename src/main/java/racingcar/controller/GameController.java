package racingcar.controller;


import java.util.List;

import racingcar.controller.util.Parser;
import racingcar.model.RacingGame;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final Validator validator;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(Validator validator, InputView inputView, OutputView outputView) {
        this.validator = validator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        List<String> carNames = Parser.parseCarNames(inputView.inputCarNames());
        carNames.forEach(validator::validateCarName);

        int attempts = validator.validateTryCount(inputView.inputTryCount());

        RacingGame game = new RacingGame(carNames, attempts);

        System.out.println("실행 결과");
        playAllRounds(game);
        outputView.printWinners(game.getWinners());
    }

    private void playAllRounds(RacingGame game) {
        for (int i = 0; i < game.getAttempts(); i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
        }
    }
}
