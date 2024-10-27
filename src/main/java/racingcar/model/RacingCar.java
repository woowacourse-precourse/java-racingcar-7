package racingcar.model;

import racingcar.utils.RandomNumber;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private List<Car> cars;

    public RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public void moving() {
        for (Car car : cars) {
            int number = RandomNumber.getNumber();
            car.move(number);
        }
    }

    public List<String> getWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream().filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName).collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition)
                .max().orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }

}
