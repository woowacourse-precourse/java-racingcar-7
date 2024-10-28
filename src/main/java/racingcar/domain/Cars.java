package racingcar.domain;

import racingcar.utils.RandomNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void moveAll(RandomNumber randomNumber) {
        for (Car car : cars) {
            int number = randomNumber.generate();
            car.move(number);
        }
    }

    public Cars findWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winningCars = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
        return new Cars(winningCars);
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
