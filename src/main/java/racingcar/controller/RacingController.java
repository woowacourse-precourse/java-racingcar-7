package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.CarNameParser;
import racingcar.utils.TryCountParser;
import racingcar.utils.WinnerDeterminer;
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
        final List<String> carNames = getCarNames();
        final Cars cars = Cars.create(carNames);

        final int tryCount = getTryCount();

        startRace(cars, tryCount);
        determineWinners(cars);
    }

    private int getTryCount() {
        outputView.printMessage(ASK_TRY_COUNT);
        final String input = inputView.userInput();

        return TryCountParser.parse(input);
    }

    private List<String> getCarNames() {
        outputView.printMessage(ASK_CAR_NAMES);
        final String input = inputView.userInput();

        return CarNameParser.parse(input);
    }

    private void startRace(final Cars cars, final int tryCount) {
        outputView.printNewLine();
        outputView.printMessage(RESULT_TITLE);

        range(0, tryCount)
                .forEach(round -> playRound(cars));
    }

    private void playRound(final Cars cars) {
        cars.play();

        outputView.printRound(cars.getCars());
        outputView.printNewLine();
    }

    private void determineWinners(final Cars cars) {
        List<String> winnerList = WinnerDeterminer.determineWinners(cars.getCars());

        outputView.printWinners(winnerList);
    }
}
