package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

import java.util.List;

import static racingcar.view.output.OutputView.*;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printMessage(ASK_CAR_NAMES);
        String carNames = inputView.userInput();

        outputView.printMessage(ASK_TRY_COUNT);
        int tryCount = Integer.parseInt(inputView.userInput());

        Race race = new Race(carNames, tryCount);

        raceStart(race);
        determineWinners(race);
    }

    private void raceStart(Race race) {
        outputView.printNewLine();
        outputView.printMessage(RESULT_TITLE);

       do {
           race.play();

           List<String> roundResults = race.getRoundResults();

           outputView.printRound(roundResults);
           outputView.printNewLine();
       } while (!race.isRaceOver());
    }

    private void determineWinners(Race race) {
        List<String> winners = race.getWinners();

        outputView.printWinners(winners);
    }
}
