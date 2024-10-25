package racingcar.controller;

import racingcar.domain.Race;
import racingcar.validator.TryCountValidator;
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
        String carNames = getCarNames();
        int tryCount = getTryCount();

        Race race = initializeRace(carNames, tryCount);

        raceStart(race);
        determineWinners(race);
    }

    private int getTryCount() {
        outputView.printMessage(ASK_TRY_COUNT);

        String input = inputView.userInput();
        TryCountValidator.validateTryCount(input);

        return Integer.parseInt(input);
    }

    private String getCarNames() {
        outputView.printMessage(ASK_CAR_NAMES);

        return inputView.userInput();
    }

    private Race initializeRace(String carNames, int tryCount) {
        return new Race(carNames, tryCount);
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
