package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name, 0));
        }
        isDuplicate(cars, names);
    }

    public void moveAll(MoveCondition moveCondition) {
        for (Car car : cars) {
            if(!moveCondition.canMove()) continue;
            car.moveForward(1);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private boolean isDuplicate(final List<Car> cars, final List<String> carNames) {
        final Set<String> uniqueNames = new HashSet<>(carNames);
        return cars.size() != uniqueNames.size();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
