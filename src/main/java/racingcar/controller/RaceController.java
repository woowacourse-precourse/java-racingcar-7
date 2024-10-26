package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceController {
    public void run() {
        String[] carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();

        Race race = new Race(Arrays.asList(carNames), rounds);

        for (int i = 0; i < rounds; i++) {
            race.start();
            ResultView.printRoundResult(race.getCars());
        }

        List<String> winners = race.getWinners();
        ResultView.printWinners(winners);
    }
}