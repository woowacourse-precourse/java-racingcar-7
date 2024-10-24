package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        String rawCarNames = receiveCarNames();
        Cars cars = createCars(rawCarNames);
        String rawTryCount = receiveTryCount();
        TryCount tryCount = new TryCount(rawTryCount);
    }

    private String receiveCarNames() {
        outputView.requestCarNames();
        return inputView.receiveString();
    }

    private Cars createCars(String rawCarNames) {
        CarNames carNames = new CarNames(rawCarNames);
        List<Car> cars = carNames.splitByComma()
                .stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    private String receiveTryCount() {
        outputView.requestTryCount();
        return inputView.receiveString();
    }
}
