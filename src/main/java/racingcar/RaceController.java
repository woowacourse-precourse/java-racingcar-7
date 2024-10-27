package racingcar;

import java.util.List;

public class RaceController {
    public void run() {
        String carNames = InputView.inputCarNames();
        Cars cars = new Cars();
        cars.createCars(carNames);
        int tryCount = InputView.inputTryCount();

        System.out.println();
        System.out.println("실행 결과");

        for (int n = 0; n < tryCount; n++) {
            cars.moveAllCars();
            OutputView.printCarStatus(cars);
        }

        int maxPosition = cars.findMaxPosition();
        List<Car> winner = cars.findWinner(maxPosition);
        OutputView.printWinner(winner);
    }
}
