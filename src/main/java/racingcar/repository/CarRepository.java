package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.MoveConditionChecker;
import racingcar.domain.NumberGenerator;

public class CarRepository {
    private final MoveConditionChecker moveConditionChecker;
    private final List<Car> cars;

    public CarRepository(NumberGenerator numberGenerator) {
        this.moveConditionChecker = new MoveConditionChecker(numberGenerator);
        this.cars = new ArrayList<>();
    }

    public void saveAll(List<Car> newCars) {
        cars.addAll(newCars);
    }

    public void attemptMoveAllCars() {
        cars.stream()
                .filter(car -> moveConditionChecker.canMove())
                .forEach(Car::move);
    }

    public List<Car> getCurrentCars() {
        return cars.stream()
                .map(Car::new)
                .toList();
    }
}
