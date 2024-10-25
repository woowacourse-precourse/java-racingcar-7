package model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    public void addCar(String newCarName) {
        Car car = new Car(newCarName);
        carList.add(car);
    }

    public List<Car> getCars() {
        return carList;
    }
}
