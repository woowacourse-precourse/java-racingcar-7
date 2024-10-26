package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move());
    }

    public List<String> getWinnerNames() {
        final int maxPosition = getMaxPosition();

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .toList();

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .min()
                .getAsInt();

        return maxPosition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
