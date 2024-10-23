package factory;

import java.util.ArrayList;
import java.util.List;
import model.Car;

public class CarFactory {

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name, 0));
        }
        return cars;
    }
}
