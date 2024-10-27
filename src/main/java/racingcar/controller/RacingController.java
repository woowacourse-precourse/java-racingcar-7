package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;
    private final CarFactory carFactory;

    public RacingController(InputView inputView, CarFactory carFactory) {
        this.inputView = inputView;
        this.carFactory = carFactory;
    }

    public void startGame() {
        String carNames = inputView.inputCarNames();

        ArrayList<Car> carList = carFactory.createCar(carNames);

        Long movingCount = inputView.inputMovingCount();
    }
}
