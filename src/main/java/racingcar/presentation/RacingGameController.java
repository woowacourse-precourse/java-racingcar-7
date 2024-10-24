package racingcar.presentation;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.RacingService;
import racingcar.domain.game.ScoreBoard;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;
    private final RaceResultFormatter raceResultFormatter;

    public RacingGameController(RacingService racingService) {
        this.racingService = racingService;
        this.raceResultFormatter = new RaceResultFormatter();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run(){
        try {
            String carNames = inputView.getCarNames();
            String rawCount = inputView.getTrialCount();

            ScoreBoard scoreBoard = racingService.getRacingResult(carNames, rawCount);
            String racingResults = raceResultFormatter.formatScoreBoard(scoreBoard);

            outputView.printRunStarted();
            outputView.print(racingResults);
        } finally {
            Console.close();
        }
    }
}
