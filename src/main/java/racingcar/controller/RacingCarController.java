package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;
    private final Cars cars;

    public RacingCarController(InputView inputView, Cars cars) {
        this.inputView = inputView;
        this.cars = cars;
    }

    public void start() {
        initializeCars();
    }

    private void initializeCars() {
        inputView.printCarNameInputGuide();
        String carNames = inputView.getCarNameInput();
        registerCars(carNames);
    }

    private void registerCars(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            Car car = new Car(carName);
            cars.saveCar(car);
        }
    }
}
