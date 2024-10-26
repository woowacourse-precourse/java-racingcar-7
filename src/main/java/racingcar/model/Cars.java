package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void addCar(String name) {
        carList.add(new Car(name));
    }
}
