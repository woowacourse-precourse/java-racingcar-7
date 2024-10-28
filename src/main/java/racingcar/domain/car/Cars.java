package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    protected Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move());
    }

    public List<Car> getWinnerNames() {
        final int maxPosition = getMaxPosition();

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return maxPosition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
