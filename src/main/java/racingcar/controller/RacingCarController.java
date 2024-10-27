package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.CarNameInputValidator;
import racingcar.view.MoveCountInputValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final CarNameInputValidator carNameInputValidator = new CarNameInputValidator();
    private final MoveCountInputValidator moveCountInputValidator = new MoveCountInputValidator();

    public void startRace() {
        List<String> carNames = carNameInputValidator.getCarNames();

        List<Car> cars = createCars(carNames);

        int moveCount = moveCountInputValidator.getMoveCount();

    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
