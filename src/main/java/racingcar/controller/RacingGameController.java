package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.RacingCarGame;
import racingcar.util.NumberParser;
import racingcar.view.RacingCarGameInputView;
import racingcar.view.RacingCarGameOutputView;

public class RacingGameController {

    public void run() {
        Cars cars = new Cars(RacingCarGameInputView.inputCarNames());
        int totalRounds = NumberParser.parsePositiveInteger(RacingCarGameInputView.inputTotalRound());
        RacingCarGame racingCarGame = new RacingCarGame(cars, totalRounds);

        RacingCarGameOutputView.printExecutionResultHeader();
        do {
            racingCarGame.runRound();
            RacingCarGameOutputView.printCarPositions(cars);
        } while (!racingCarGame.isEndAllRounds());

        List<String> winners = racingCarGame.determineWinners();
        RacingCarGameOutputView.printWinners(winners);
    }
}