package racingcar.controller;

import java.util.List;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private Racing racing;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        createRacing();
        runRacing();
        displayWinner();
    }

    private void createRacing() {
        List<String> cars = readyCars();
        int tryCount = readyTryCount();
        this.racing = Racing.of(cars, tryCount);
    }

    private List<String> readyCars() {
        outputView.printInputCarNames();
        return inputView.inputCarNames();
    }

    private int readyTryCount() {
        outputView.printInputRacingCount();
        return inputView.inputTryCount();

    }

    private void runRacing() {
        outputView.printRacingResultMessage();
        while (racing.can()) {
            racing.run();
            racing.deductTryCount();
            outputView.printRacingResult(racing.getResult());
        }
    }

    private void displayWinner() {
        List<String> winners = racing.getWinners();
        outputView.printWinner(winners);
    }
}
