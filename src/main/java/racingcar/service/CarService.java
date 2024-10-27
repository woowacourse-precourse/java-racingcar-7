package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

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
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                car.move();
            }
        }
    }
}
