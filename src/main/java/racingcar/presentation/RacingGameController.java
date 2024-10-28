package racingcar.presentation;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingGame;
import racingcar.domain.RoundCount;
import racingcar.domain.ScoreBoard;
import racingcar.domain.Cars;
import racingcar.domain.MovingStrategy;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovingStrategy movingStrategy;
    private final RaceResultFormatter raceResultFormatter;

    public RacingGameController(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
        this.raceResultFormatter = new RaceResultFormatter();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            Cars cars = getCarsFromInput();
            RoundCount roundCount = getRoundCountFromInput();
            ScoreBoard scoreBoard = playRacingGame(cars, roundCount);
            printResults(scoreBoard);
        } finally {
            Console.close();
        }
    }

    private Cars getCarsFromInput() {
        String carNames = inputView.getCarNames();
        InputValidator.validateCarNamesInput(carNames);
        return Cars.of(carNames, movingStrategy);
    }

    private RoundCount getRoundCountFromInput() {
        String rawCount = inputView.getTrialCount();
        InputValidator.validateTrialCountInput(rawCount);
        return RoundCount.of(rawCount);
    }

    private ScoreBoard playRacingGame(Cars cars, RoundCount roundCount) {
        RacingGame racingGame = new RacingGame(cars, roundCount, ScoreBoard.ofEmpty());
        return racingGame.play();
    }

    private void printResults(ScoreBoard scoreBoard) {
        String racingResults = raceResultFormatter.formatScoreBoard(scoreBoard);
        outputView.printRunStarted();
        outputView.print(racingResults);
    }
}
