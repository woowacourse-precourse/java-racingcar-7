package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.RaceRound;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingController {
    public void run() {
        List<String> carNames = InputView.getCarNames();
        int numberOfRounds = InputView.getNumberOfRounds();

        Race race = new Race(carNames, numberOfRounds);
        RaceRound raceRound = new RaceRound(race);

        for (int i = 0; i < numberOfRounds; i++) {
            raceRound.playRound();
            ResultView.printRoundResult(race.getCars());
        }

        ResultView.printWinners(race.getWinners());
    }
}
