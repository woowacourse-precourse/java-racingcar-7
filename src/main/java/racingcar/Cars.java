package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

//    public Cars(List<Car> cars) {
//        this.cars = cars;
//    }

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

//    public int sizeOfCars() {
//        return cars.size();
//    }
}
