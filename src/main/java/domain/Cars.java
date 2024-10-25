package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromCarNames(CarNames names) {
        List<Car> cars = names.getNames().stream().map(carName-> new Car(carName.getName())).collect(Collectors.toList());
        return new Cars(cars);
    }

    public void moveCars() {
        for(Car car: cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
