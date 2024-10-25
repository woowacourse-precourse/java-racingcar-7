package racingcar.service;

import racingcar.model.Car;

public class CarService {

    public Car[] createCars(String[] carNameList) {
        Car[] cars = new Car[carNameList.length];

        for (int i = 0; i < carNameList.length; i++) {
            cars[i] = new Car(carNameList[i]);
        }

        return cars;
    }
}
