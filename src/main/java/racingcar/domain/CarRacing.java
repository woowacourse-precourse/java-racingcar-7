package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final List<Car> carList = new ArrayList<>();

    public CarRacing(List<String> cars) {
        for (String car : cars) {
            carList.add(new Car(car));
        }
    }

    public List<Car> getCars() {
        return carList;
    }

    public void go() {
        for (Car car : carList) {
            car.go();
        }
    }
}
