package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createCarByName(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name.trim()));
        }
        return carList;
    }
}
