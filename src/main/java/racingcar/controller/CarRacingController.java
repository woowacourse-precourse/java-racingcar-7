package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.utils.randomnumbergenerator.DefaultRandomNumberGenerator;
import racingcar.utils.randomnumbergenerator.RandomNumberGenerator;
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

    public void startRace() {
        List<String> carNames = inputView.askCarNames();
        List<Car> cars = createCars(carNames);
        int tryCount = inputView.askTryCount();

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move(randomNumberGenerator);
            }
            outputView.displayCarRacingStatus(cars);
        }
        outputView.printWinnerMessage(cars);
    }

}
