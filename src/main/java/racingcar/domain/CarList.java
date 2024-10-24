package racingcar.domain;

import java.util.List;
import racingcar.utils.RandomGenerator;

public class CarList {
    private final List<Car> carList;
    private final RandomGenerator randomGenerator;

    public CarList(List<Car> carList, RandomGenerator randomGenerator) {
        this.carList = carList;
        this.randomGenerator = randomGenerator;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveAll() {
        carList.forEach(car -> car.move(randomGenerator.generate()));
    }

    public List<Car> getWinners() {
        return carList.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .toList();
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
