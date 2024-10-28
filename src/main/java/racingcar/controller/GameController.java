package racingcar.controller;

import java.util.List;
import racingcar.model.InputValidator;
import racingcar.model.RacingGame;
import racingcar.model.RacingJudge;
import racingcar.model.RacingRecord;
import racingcar.view.AttemptsInputView;
import racingcar.view.NameInputView;
import racingcar.view.OutputView;
import racingcar.view.RoundView;
import racingcar.view.View;

public class GameController {

    private RacingGame racingGame;
    private RacingJudge racingJudge;
    private View view;
    private InputValidator validator;

    public GameController(RacingGame racingGame, RacingJudge racingJudge) {
        this.racingGame = racingGame;
        this.racingJudge = racingJudge;
        this.validator = new InputValidator();
    }

    public void run() {
        view = new NameInputView();
        String names = view.printView();

        validator.checkValidNames(names);

        view = new AttemptsInputView();
        String attempts = view.printView();

        validator.checkValidAttempts(attempts);

        racingGame = new RacingGame(names);
        view = new RoundView(racingGame);
        for (int i = 0; i < Integer.parseInt(attempts); i++) {
            List<Integer> randomNumbers = racingGame.generateRandomNumbers();
            racingGame.racing(randomNumbers);
            view.printView();
        }
        List<RacingRecord> records = racingGame.getRecords();
        String winners = racingJudge.decideWinnerBy(records);

        view = new OutputView(winners);
        view.printView();
    }
}
