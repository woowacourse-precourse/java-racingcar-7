package racingcar.feature;

import racingcar.obj.Car;

public class ProduceCar {

    public Car[] getCars(String[] carsName) {
        int len = carsName.length;
        Car[] cars = new Car[len];
        for (int i = 0; i < len; i++) {
            cars[i] = new Car(carsName[i]);
        }
        return cars;
    }

}
