package racingcar.Controller;

import racingcar.Model.Cars;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RaceController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void gameStart() {
        String carNames = inputView.InputCarNames();
        Cars cars = new Cars(carNames);

        int inputTryCount = inputView.InputTryCounts();

        repeatRun(inputTryCount, cars);
        outputView.printWinners(cars.getWinner());

    }

    void repeatRun(int tryCount, Cars cars) {
        System.out.println("실행 결과");

        while(tryCount > 0) {
            cars.runCars();
            outputView.printProgressStatus(cars.getCars());
            tryCount--;
        }
    }
}
