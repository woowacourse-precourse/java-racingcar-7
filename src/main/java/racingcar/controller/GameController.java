package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    public void run() {
        try {
            List<String> carNames = InputView.getCarNames();
            Cars cars = new Cars(carNames);
            int repeatCount = InputView.getRepeatCount();

            System.out.println("\n실행 결과");
            for (int i = 0; i < repeatCount; i++) {
                cars.moveCars();
                OutputView.printRaceStatus(cars.getCars());
            }

            List<String> winners = cars.getWinners();
            OutputView.printWinners(winners);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
    }
}
