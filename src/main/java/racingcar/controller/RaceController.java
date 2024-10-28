package racingcar.controller;

import racingcar.model.RaceResult;
import racingcar.service.RaceService;
import racingcar.model.RoundPositions;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.raceService = new RaceService();
    }

    public void run() {
        try {
            outputView.printCarNamePrompt();
            List<String> carNames = inputView.getCarNames();

            outputView.printAttemptPrompt();
            int attempts = inputView.getNumberOfAttempts();

            outputView.printRaceResultStart();

            RaceResult result = raceService.start(carNames, attempts);

            // 라운드 별 기록 출력
            for (RoundPositions roundPosition : result.roundPositions().getProgress()) {
                outputView.printRaceRound(carNames, roundPosition.positions());
            }

            outputView.printWinners(result.winners());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            throw e;
        } finally {
            inputView.close();
        }
    }
}