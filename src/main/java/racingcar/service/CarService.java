package racingcar.service;

import racingcar.model.Car;

import java.util.Map;

public class CarService {

    private final Car car;

    public CarService(){
        this.car = new Car();
    }

    public Map<String, Integer> carNames(String inputCarName) {
        return car.carNameSplit(inputCarName);
    }
}
