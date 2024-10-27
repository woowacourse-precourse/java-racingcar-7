package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;

public class CarService {
    private final ArrayList<Car> cars;

    public CarService() {
        this.cars = new ArrayList<>();
    }

    public void addCars(ArrayList<Car> newCars) {
        cars.addAll(newCars);
    }


}
