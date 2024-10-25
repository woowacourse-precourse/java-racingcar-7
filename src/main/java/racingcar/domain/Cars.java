package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        cars.forEach(Car::moveForward);
    }

    public String getCurrentRoundResult() {
        StringBuilder builder = new StringBuilder();
        cars.forEach(builder::append);

        return builder.toString();
    }

    public String findWinnerCarNames() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
