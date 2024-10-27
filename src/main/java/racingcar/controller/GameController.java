package racingcar.controller;

import java.io.IOException;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final CarService carService = new CarService();

    public void startGame() throws IOException {
        String carNames = inputView.getCarNames();
        List<Car> cars = carService.createCars(carNames);

    }

    private void playGame() {

    }
}
