package racingcar.car.service;

import static racingcar.global.util.CarConst.MAX_CAR_COUNT;
import static racingcar.global.util.CarConst.MIN_CAR_COUNT;

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
        String[] split = getCarNames(carInput);
        for (String s : split) {
            cars.add(new Car(s));
        }
        validCarsRange();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(Car car) {
        car.move(randomHolder);
    }

    private static String[] getCarNames(String carInput) {
        return carInput.split(",");
    }

    private void validCarsRange() {
        if (cars.size() < MIN_CAR_COUNT || cars.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CARS_RANGE.getMessage());
        }
    }
}
