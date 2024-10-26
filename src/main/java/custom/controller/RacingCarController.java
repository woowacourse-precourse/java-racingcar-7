package custom.controller;

import custom.model.RacingScoreBoard;
import custom.service.CarNameParser;
import custom.service.GetAttemptCount;
import custom.service.RaceExecutor;
import custom.view.InputView;
import custom.view.OutputView;
import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final RacingScoreBoard racingScoreBoard;
    private final CarNameParser carNameParser;
    private final GetAttemptCount getAttemptCount;
    private final RaceExecutor raceExecutor;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.racingScoreBoard = new RacingScoreBoard();
        this.carNameParser = new CarNameParser();
        this.getAttemptCount = new GetAttemptCount();
        this.raceExecutor = new RaceExecutor();
        this.outputView = new OutputView();
    }

    public void run() {
        String carNamesInput = inputView.displayCarNamePrompt();
        List<String> carList = carNameParser.run(carNamesInput);

        String attemptCountInput = inputView.displayCountPrompt();
        int attemptCount = getAttemptCount.run(attemptCountInput);

        racingScoreBoard.registerCars(carList);
        outputView.displayRaceResultPrompt();

        for (int round = 1; round <= attemptCount; round++) {
            raceExecutor.run();
            outputView.displayRaceResultsByRound(racingScoreBoard.getAllScores());
        }
        outputView.displayRaceWinners(racingScoreBoard.getWinners());
    }
}