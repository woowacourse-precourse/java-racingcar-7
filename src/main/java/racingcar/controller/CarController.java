package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.util.InputView;
import racingcar.util.OutputView;

public class CarController {
    private final CarService carService;
    private final InputView inputView;
    private final OutputView outputView;
    private List<Car> cars;
    private int numberOfTries;

    public CarController(CarService carService, InputView inputView, OutputView outputView) {
        this.carService = carService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        gameInit();
        game();
        gameOver();
    }

    private void gameInit() {
        String carNamesWithDelimiter = inputView.getCarInput();
        String[] carNames = carService.getCarsByDelimiter(carNamesWithDelimiter);
        cars = carService.getCarsByCarNames(carNames);
        numberOfTries = carService.getNumber(inputView.getTries());
    }

    private void game() {
    }

    private void gameOver() {
    }
}
