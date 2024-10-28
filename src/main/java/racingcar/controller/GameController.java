package racingcar.controller;

import java.util.List;
import racingcar.model.GameModel;
import racingcar.model.Generator;
import racingcar.model.InputValidator;
import racingcar.model.RacingGame;
import racingcar.model.RacingJudge;
import racingcar.model.RacingRecord;
import racingcar.view.AttemptsInputView;
import racingcar.view.OutputView;
import racingcar.view.RoundView;
import racingcar.view.View;

public class GameController {

    private final GameModel gameModel;
    private View view;
    private final InputValidator validator;

    public GameController(GameModel gameModel, View view) {
        this.gameModel = gameModel;
        this.view = view;
        this.validator = new InputValidator();
    }

    public void run() {
        String names = view.printView();

        validator.checkValidNames(names);

        view = new AttemptsInputView();
        String attempts = view.printView();

        validator.checkValidAttempts(attempts);

        Generator generator = gameModel.getGenerator();
        List<RacingRecord> records = generator.generateRecordsFrom(names);

        RacingGame racingGame = gameModel.getRacingGameEngine();

        view = new RoundView(records);
        for (int i = 0; i < Integer.parseInt(attempts); i++) {
            List<Integer> randomNumbers = generator.generateRandomNumbers(records.size());
            racingGame.racing(randomNumbers, records);
            view.printView();
        }

        RacingJudge racingJudge = gameModel.getRacingJudge();
        String winners = racingJudge.decideWinnerBy(records);

        view = new OutputView(winners);
        view.printView();
    }
}
