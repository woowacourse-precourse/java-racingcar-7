package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.TryCountParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static java.util.stream.IntStream.range;
import static racingcar.view.OutputView.*;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String carNames = getCarNames();
        Cars cars = initializeRace(carNames);

        int tryCount = getTryCount();

        raceStart(cars, tryCount);
        determineWinners(cars);
    }

    private int getTryCount() {
        outputView.printMessage(ASK_TRY_COUNT);
        String input = inputView.userInput();

        return TryCountParser.parse(input);
    }

    private String getCarNames() {
        outputView.printMessage(ASK_CAR_NAMES);

        return inputView.userInput();
    }

    private Cars initializeRace(String carNames) {
        return new Cars(carNames);
    }

    private void raceStart(Cars cars, int tryCount) {
        outputView.printNewLine();
        outputView.printMessage(RESULT_TITLE);

       range(0, tryCount)
               .forEach(round -> playRound(cars));
    }

    private void playRound(Cars cars) {
        cars.play();

        List<String> roundResults = cars.getRoundResults();

        outputView.printRound(roundResults);
        outputView.printNewLine();
    }

    private void determineWinners(Cars cars) {
        List<String> winners = cars.getWinners();

        outputView.printWinners(winners);
    }
}
