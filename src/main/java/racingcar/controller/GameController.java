package racingcar.controller;

import java.util.List;
import racingcar.model.InputValidator;
import racingcar.model.RacingGame;
import racingcar.model.RacingJudge;
import racingcar.model.RacingRecord;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.RoundView;

public class GameController {

    private RacingGame racingGame;
    private RacingJudge racingJudge;
    private InputView inputView;
    private RoundView roundView;
    private OutputView outputView;
    private InputValidator validator;

    public GameController(RacingGame racingGame, RacingJudge racingJudge) {
        this.racingGame = racingGame;
        this.racingJudge = racingJudge;
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.roundView = new RoundView(racingGame);
        this.validator = new InputValidator();
    }

    public void run() {
        inputView.printCarNamesRequest();
        String names = inputView.getCarNames();

        validator.checkValidNames(names);

        inputView.printNumberOfAttemptsRequest();
        String attempts = inputView.getNumberOfAttempts();

        validator.checkValidAttempts(attempts);

        racingGame = new RacingGame(names);
        roundView = new RoundView(racingGame);
        roundView.printStartMessage();
        for (int i = 0; i < Integer.parseInt(attempts); i++) {
            List<Integer> randomNumbers = racingGame.generateRandomNumbers();
            racingGame.racing(randomNumbers);
            roundView.printRound();
        }
        List<RacingRecord> records = racingGame.getRecords();
        String winners = racingJudge.decideWinnerBy(records);

        outputView.printWinners(winners);
    }
}
