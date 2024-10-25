package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    static List<Car> carList = new ArrayList<>();

    public static List<Car> getCarList() {
        String[] cars = User.getCars();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }
}
