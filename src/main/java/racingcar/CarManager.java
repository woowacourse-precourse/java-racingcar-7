package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private static CarManager instance;
    private List<Car> carList;

    private CarManager() {}

    public static CarManager getInstance() {
        if (instance == null) {
            instance = new CarManager();
        }
        return instance;
    }

    public List<Car> getCars() {
        return carList;
    }

    public void makeCarList(String carName) {
        carList.add(new Car(carName));
    }
}
