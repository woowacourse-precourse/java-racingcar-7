package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.RacingCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Racing racing = creatRacing();
        runRacing(racing);
        disPlayWinner(racing);
    }

    private Racing creatRacing() {
        Cars cars = readyCars();
        RacingCount racingCount = readyRacingCount();
        return Racing.of(cars, racingCount);
    }

    private Cars readyCars() {
        outputView.printInputCarNames();
        List<String> carNames = inputView.inputCarNames();
        return Cars.fromNames(carNames);
    }

    private RacingCount readyRacingCount() {
        outputView.printInputRacingCount();
        int tryCount = inputView.inputTryCount();
        return RacingCount.from(tryCount);
    }

    private void runRacing(Racing racing) {
        outputView.printRacingResultMessage();
        while (racing.can()) {
            racing.run();
            racing.deductTryCount();
            outputView.printRacingResult(racing.getResult());
        }
    }

    private void disPlayWinner(Racing racing) {
        List<String> winners = racing.getWinners();
        outputView.printWinner(winners);
    }
}
