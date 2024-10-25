package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        String[] cars = User.getCars();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }
}
