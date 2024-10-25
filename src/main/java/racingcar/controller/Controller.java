package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.Round;
import static racingcar.view.InputView.readLine_racingCarNames;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    public static void run() {
        Race race = new Race(readLine_racingCarNames());
        Round round = new Round(InputView.readLine_round());
        for (int i = 0; i < round.length(); i++) {
            race.runOneRound();
        }
        OutputView.printWinnerResult(race.getWinnerNames());
    }
}
