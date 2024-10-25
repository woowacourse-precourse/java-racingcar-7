package racingcar.car;

import java.util.List;

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
}
