package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class InitCars {
    public static List<Car> initCars(String[] carNameArray) {
        List<Car> carList = new ArrayList<>();
        for (String carName: carNameArray) {
            carList.add(new Car(carName));
        }
        return carList;
    }
}
