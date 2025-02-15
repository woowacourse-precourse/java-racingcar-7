package racingcar.controller;

import racingcar.model.Race;

import static racingcar.view.InputView.readLine_racingCarNames;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    public static void run() {
        Race race = new Race(readLine_racingCarNames(), InputView.readLine_round());
        race.runRace();
        OutputView.printWinnerResult(race.getWinnerNames());
    }
}
