package controller;

import java.util.List;
import racingcar.Car;
import racingcar.Racing;
import view.InputView;
import view.OutputView;

public class RacingController {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Car> cars = inputView.inputCarNames();
        int attemptCount = inputView.inputAttemptCount();
        Racing racing = new Racing(cars, attemptCount);

        outputView.printRacingResult(racing);
        outputView.printFinalWinners(racing);
    }

}
