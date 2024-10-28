package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RandomNumber;

import java.util.ArrayList;

public class CarService {
    private final ArrayList<Car> cars;

    public CarService() {
        this.cars = new ArrayList<>();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCars(ArrayList<Car> newCars) {
        cars.addAll(newCars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(new RandomNumber());
        }
    }
}
