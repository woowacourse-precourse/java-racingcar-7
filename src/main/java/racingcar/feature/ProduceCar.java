package racingcar.feature;

import racingcar.obj.Car;

import java.util.ArrayList;
import java.util.List;

public class ProduceCar {

    public List<Car> getCars(String[] carsName) {
        int len = carsName.length;
        var carList = new ArrayList<Car>();
        Car[] cars = new Car[len];
        for (int i = 0; i < len; i++) {
            carList.add(new Car(carsName[i]));
        }
        return carList;
    }

}
