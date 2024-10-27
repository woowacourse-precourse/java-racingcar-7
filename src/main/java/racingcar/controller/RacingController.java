package racingcar.controller;

import racingcar.model.Racing;
import racingcar.view.OutputView;

import static racingcar.view.InputView.inputAttempts;
import static racingcar.view.InputView.inputCars;


public class RacingController {
    public static void run() {
        String[] cars = inputCars();
        int attempts = inputAttempts();

        Racing racing = new Racing(cars, attempts);

        racing.start();

        String winners = racing.getWinners();
        OutputView.printWinners(winners);
    }
}
