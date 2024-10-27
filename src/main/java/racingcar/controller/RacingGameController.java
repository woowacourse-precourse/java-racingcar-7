package racingcar.controller;

import java.util.List;
import racingcar.dto.CarLocation;
import racingcar.model.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        List<String> carNames = inputView.getCarNames();
        int attempts = inputView.getAttempts();
        RacingGame racingGame = racingGameService.initializeRace(carNames, attempts);

        outputView.printRaceResultPrefix();
        List<List<CarLocation>> raceHistory = racingGameService.runRace(racingGame);

        raceHistory.forEach(outputView::printRaceProcess);

        List<String> winners = racingGameService.getWinners(racingGame.cars());
        outputView.printWinners(winners);
    }
}
