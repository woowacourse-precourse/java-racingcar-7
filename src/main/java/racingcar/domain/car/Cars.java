package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.common.exception.CarDuplicateException;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        if(cars.contains(car)) {
            throw new CarDuplicateException(car.getCarName());
        }
        cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
