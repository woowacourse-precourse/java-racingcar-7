package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsManager {

    private final List<Car> cars;

    public CarsManager(List<Car> cars) {
        this.cars = cars;
    }

    public static CarsManager by(List<String> carNames){
        return new CarsManager(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move(){
        for (Car car : cars) {
            car.move();
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::getResult)
                .collect(Collectors.joining());
    }

}
