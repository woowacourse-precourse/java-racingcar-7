package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.DefaultRandomNumberGenerator;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public CarRacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = new DefaultRandomNumberGenerator();
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
