package racingcar.service;

import racingcar.model.Car;

import java.util.Map;

public class CarService {

    Car car;

    public CarService(){
        this.car = new Car();
    }

    public String racing(String inputCarName) {

        Map<String, Integer> cars = car.carNameSplit(inputCarName);
        System.out.println(cars);

        return null;
    }
}
