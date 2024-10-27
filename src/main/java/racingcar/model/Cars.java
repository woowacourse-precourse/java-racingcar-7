package racingcar.model;

import java.util.ArrayList;

// TODO: 일급 컬렉션에 부합하는지 좀 더 고려
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

    public int count() {
        return cars.size();
    }

    public String nameAt(int index) {
        return cars.get(index).getName();
    }

    public int countMoveAt(int index) {
        return cars.get(index).countMove();
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public ArrayList<String> getWinnerNames() {
        int maxMoveCount = findMaxMovedCount();

        return new ArrayList<>(
                cars.stream()
                        .filter(car -> car.countMove() == maxMoveCount)
                        .map(Car::getName)
                        .toList()
        );
    }

    private int findMaxMovedCount() {
        return cars.stream()
                .mapToInt(Car::countMove)
                .max()
                .getAsInt();
    }
}
