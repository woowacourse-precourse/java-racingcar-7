package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarMover;
import racingcar.view.CarNameInputValidator;
import racingcar.view.MoveCountInputValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final CarNameInputValidator carNameInputValidator;
    private final MoveCountInputValidator moveCountInputValidator;
    private final List<Car> cars;
    private final CarMover carMover;

    public RacingCarController(CarNameInputValidator carNameInputValidator,
                               MoveCountInputValidator moveCountInputValidator,
                               CarMover carMover) {
        this.carNameInputValidator = carNameInputValidator;
        this.moveCountInputValidator = moveCountInputValidator;
        this.cars = new ArrayList<>();
        this.carMover = carMover;
    }

    public void startRace() {
        List<String> carNames = carNameInputValidator.getCarNames();
        createCars(carNames);

        int moveCount = moveCountInputValidator.getMoveCount();

        for (int i = 0; i < moveCount; i++) {
            moveCars();
            printResults();
        }
    }

    public void createCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            if (carMover.canMove()) {
                car.move();
            }
        }
    }

    public void printResults() {
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                sb.append("-");
            }
            System.out.println(sb.toString());
        }
        System.out.println();
    }
}
