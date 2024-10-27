package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int SPLIT_ALL = -1;
    private static final String DELIMITER = ",";

    private final ArrayList<Car> cars;

    public Cars(String names) {
        cars = new ArrayList<>();
        for (String name : names.split(DELIMITER, SPLIT_ALL)) {
            cars.add(new Car(name));
        }
    }

    public List<Car> toList() {
        return cars.stream()
                .map(Car::clone)
                .toList();
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinnerNames() {
        int maxMoveCount = findMaxMovedCount();

        return cars.stream()
                .filter(car -> car.countMove() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }

    private int findMaxMovedCount() {
        return cars.stream()
                .mapToInt(Car::countMove)
                .max()
                .getAsInt();
    }
}
