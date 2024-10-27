package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.CarNameParser;
import racingcar.utils.TryCountParser;
import racingcar.utils.WinnerDeterminer;

import java.util.List;
import racingcar.view.InputView;

import static java.util.stream.IntStream.range;
import static racingcar.view.OutputView.*;

public class RacingController {

    public void run() {
        final List<String> carNames = getCarNames();
        final Cars cars = Cars.createFromCarNames(carNames);

        final int tryCount = getTryCount();

        startRace(cars, tryCount);
        determineWinners(cars);
    }

    private int getTryCount() {
        printMessage(ASK_TRY_COUNT);
        final String input = InputView.userInput();

        return TryCountParser.parse(input);
    }

    private List<String> getCarNames() {
        printMessage(ASK_CAR_NAMES);
        final String input = InputView.userInput();

        return CarNameParser.parse(input);
    }

    private void startRace(final Cars cars, final int tryCount) {
        printNewLine();
        printMessage(RESULT_TITLE);

        range(0, tryCount)
                .forEach(round -> playRound(cars));
    }

    private void playRound(final Cars cars) {
        cars.play();

        printRound(cars.getCars());
        printNewLine();
    }

    private void determineWinners(final Cars cars) {
        List<String> winnerList = WinnerDeterminer.determineWinners(cars.getCars());

        printWinners(winnerList);
    }
}
