package racingcar.controller;

import java.util.List;
import racingcar.dto.CarLocation;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.service.RaceProgressService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RaceProgressService raceProgressService = new RaceProgressService(randomNumberGenerator);
        this.racingGameService = new RacingGameService(raceProgressService);
    }

    public void run() {
        RacingGame racingGame = initializeRaceGame();
        outputView.printRaceResultPrefix();
        processRaceRecord(racingGame);
        displayWinners(racingGame);
    }

    private RacingGame initializeRaceGame() {
        List<String> carNames = inputView.getCarNames();
        int attempts = inputView.getAttempts();
        return racingGameService.initializeRace(carNames, attempts);
    }

    private void processRaceRecord(RacingGame racingGame) {
        List<List<CarLocation>> raceRecord = racingGameService.runRaceRounds(racingGame);
        raceRecord.forEach(outputView::printRaceProcess);
    }

    private void displayWinners(RacingGame racingGame) {
        List<String> winners = racingGameService.getWinners(racingGame.cars());
        outputView.printWinners(winners);
    }
}
