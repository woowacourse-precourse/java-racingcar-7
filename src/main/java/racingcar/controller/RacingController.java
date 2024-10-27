package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;

    public RacingController() {
        this.inputView = new InputView();
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        int moveCount = inputView.readMoveCount();

        Cars cars = initializeCars(carNames);
        OutputView outputView = new OutputView(cars);

        race(cars, moveCount, outputView);
        outputView.printWinners();
    }

    protected Cars initializeCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }

    private void race(Cars cars, int moveCount, OutputView outputView) {
        for(int i = 0; i < moveCount; i++) {
            cars.moveAll();
            outputView.printProgress();
        }
    }
}
