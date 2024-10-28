package racingcar.controller;

import racingcar.model.Racing;
import racingcar.view.OutputView;

import static racingcar.view.InputView.*;


public class RacingController {
    public static void run() {
        String[] cars = parseCars(inputCars());
        int attempts = parseAttempts(inputAttempts());

        Racing racing = new Racing(cars, attempts);

        racing.start();

        String winners = racing.getWinners();
        OutputView.printWinners(winners);
    }
}
