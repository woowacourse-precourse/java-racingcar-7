package racingcar.feature;

import racingcar.obj.Car;

import java.util.ArrayList;
import java.util.List;

public class ProduceCar {

    public List<Car> getCars(String[] carsName) {
        var carList = new ArrayList<Car>();
        for (String s : carsName) {
            carList.add(new Car(s));
        }
        return carList;
    }

}
