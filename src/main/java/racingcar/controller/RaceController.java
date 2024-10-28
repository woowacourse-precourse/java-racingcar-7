package racingcar.controller;

import racingcar.service.RaceResult;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.raceService = new RaceService();
    }

    public void run() {
        try {
            List<String> carNames = inputView.getCarNames();
            int attempts = inputView.getNumberOfAttempts();
            outputView.printRaceResultStart();

            RaceResult result = raceService.start(carNames, attempts);
            for (List<Integer> roundPosition : result.roundPositions()) {
                outputView.printRaceRound(carNames, roundPosition);
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
