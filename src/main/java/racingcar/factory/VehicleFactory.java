package racingcar.factory;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class VehicleFactory {
    public static List<Car> createCars(String[] names) {
        List<Car> Cars = new ArrayList<>();
        for(String name : names)
            Cars.add(new Car(name));
        return Cars;
    }
}
