package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.strategy.IntGeneratorStrategy;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames, IntGeneratorStrategy intGeneratorStrategy) {
        this.cars = new ArrayList<>();
        initCars(carNames, intGeneratorStrategy);
    }

    public void requestCarMove() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getLongestPosition() {
        return calculateLongestPosition();
    }

    private void initCars(List<String> carNames, IntGeneratorStrategy intGeneratorStrategy) {
        for (String carName : carNames) {
            Car car = new Car(carName, intGeneratorStrategy);
            cars.add(car);
        }
    }

    private int calculateLongestPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}