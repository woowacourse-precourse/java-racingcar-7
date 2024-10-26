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

        Cars cars = new Cars(carNames.stream()
                .map(Car::new)
                .toList());
        OutputView outputView = new OutputView(cars);

        for(int i=0;i<moveCount;i++) {
            cars.moveAll();
            outputView.printProgress();
            System.out.println();
        }
        outputView.printWinners();
    }
}
