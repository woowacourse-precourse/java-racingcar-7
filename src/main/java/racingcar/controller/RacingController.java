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
        List<String> carNames = getCarNames();
        Cars cars = Cars.create(carNames);

        int tryCount = getTryCount();

        startRace(cars, tryCount);
        determineWinners(cars);
    }

    private int getTryCount() {
        outputView.printMessage(ASK_TRY_COUNT);
        String input = inputView.userInput();

        return TryCountParser.parse(input);
    }

    private List<String> getCarNames() {
        outputView.printMessage(ASK_CAR_NAMES);
        String input = inputView.userInput();

        return CarNameParser.parse(input);
    }

    private void startRace(Cars cars, int tryCount) {
        outputView.printNewLine();
        outputView.printMessage(RESULT_TITLE);

       range(0, tryCount)
               .forEach(round -> playRound(cars));
    }

    private void playRound(Cars cars) {
        cars.play();

        outputView.printRound(cars.getCars());
        outputView.printNewLine();
    }

    private void determineWinners(Cars cars) {
        List<String> winnerList = WinnerDeterminer.determineWinners(cars.getCars());

        outputView.printWinners(winnerList);
    }
}
