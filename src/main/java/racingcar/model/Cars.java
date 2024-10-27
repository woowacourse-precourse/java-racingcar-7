package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new ArrayList<>();
        initCars(carNames);
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

    private void initCars(List<String> carNames) {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        for (String carName : carNames) {
            Car car = new Car(carName, randomIntGenerator);
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