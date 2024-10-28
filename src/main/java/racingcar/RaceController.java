package racingcar;

import java.util.List;

public class RaceController {
    private static final String RACE_RESULT_MESSAGE = "\n실행 결과";

    public void run() {
        List<String> carNames = InputView.inputCarNames();
        List<Car> carList = Cars.createCars(carNames);
        Cars cars = new Cars(carList);
        int tryCount = InputView.inputTryCount();

        System.out.println(RACE_RESULT_MESSAGE);

        for (int n = 0; n < tryCount; n++) {
            cars.moveAllCars();
            List<String> allStatuses = cars.collectAllStatuses();
            OutputView.printCarStatus(allStatuses);
        }

        List<Car> winner = cars.findWinner();
        OutputView.printWinner(winner);
    }
}
