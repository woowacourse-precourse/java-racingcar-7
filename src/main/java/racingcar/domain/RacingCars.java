package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    List<Car> cars = new ArrayList<>();
    MoveCondition moveCondition;

    public RacingCars(List<String> names,MoveCondition moveCondition) {
        for (String name : names) {
            cars.add(new Car(name, 0));
        }
        this.moveCondition = moveCondition;
    }

    public void moveAll() {
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

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
