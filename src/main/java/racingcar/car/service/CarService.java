package racingcar.car.service;

import static racingcar.global.util.CarConst.MAX_CARS_RANGE;
import static racingcar.global.util.CarConst.MIN_CARS_RANGE;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.service.port.RandomHolder;
import racingcar.global.util.ErrorMessage;

public class CarService {

    private final RandomHolder randomHolder;
    private List<Car> cars = new ArrayList<>();

    public CarService(RandomHolder randomHolder) {
        this.randomHolder = randomHolder;
    }

    public void create(String carInput) {
        String[] split = parseCarNames(carInput);
        for (String s : split) {
            cars.add(new Car(s.trim()));
        }
        validCarsRange();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomHolder);
        }
    }

    private static String[] parseCarNames(String carInput) {
        return carInput.split(",");
    }

    private void validCarsRange() {
        if (cars.size() < MIN_CARS_RANGE || cars.size() > MAX_CARS_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CARS_RANGE.getMessage());
        }
    }
}
