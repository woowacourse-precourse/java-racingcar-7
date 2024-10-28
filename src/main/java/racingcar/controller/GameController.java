package racingcar.controller;

import java.util.List;
import racingcar.model.GameModel;
import racingcar.model.Generator;
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

    public GameController(GameModel gameModel, View view) {
        this.gameModel = gameModel;
        this.view = view;
    }

    public void run() {
        List<String> namesAndAttempts = inputPart();
        String names = namesAndAttempts.get(0);
        String attempts = namesAndAttempts.get(1);

        List<RacingRecord> records = play(names, attempts);

        endPart(records);
    }

    private List<String> inputPart() {
        String names = view.printView();

        gameModel.checkValidNames(names);

        view = new AttemptsInputView();
        String attempts = view.printView();

        gameModel.checkValidAttempts(attempts);

        return List.of(names, attempts);
    }

    private List<RacingRecord> play(String names, String attempts) {
        Generator generator = gameModel.getGenerator();
        List<RacingRecord> records = generator.generateRecordsFrom(names);

        RacingGame racingGame = gameModel.getRacingGameEngine();

        view = new RoundView(records);
        for (int i = 0; i < Integer.parseInt(attempts); i++) {
            List<Integer> randomNumbers = generator.generateRandomNumbers(records.size());
            racingGame.racing(randomNumbers, records);
            view.printView();
        }

        return records;
    }

    private void endPart(List<RacingRecord> records) {
        RacingJudge racingJudge = gameModel.getRacingJudge();
        String winners = racingJudge.decideWinnerBy(records);

        view = new OutputView(winners);
        view.printView();
    }
}
