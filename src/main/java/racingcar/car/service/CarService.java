package racingcar.car.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.service.port.RandomHolder;

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
}
