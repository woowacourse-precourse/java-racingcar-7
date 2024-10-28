package racingcar;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String carName) {
        this.cars = createCars(carName);
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    private List<Car> createCars(String carName) {
        List<CarName> carNames = new CarNames(carName).getCarNames();

        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
