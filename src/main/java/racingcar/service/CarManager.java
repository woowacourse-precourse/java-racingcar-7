package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars;

    public CarManager() {
        this.cars = new ArrayList<>();
    }

    public void createCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}

//추후에 차 관련 메소드 더 추가 가능