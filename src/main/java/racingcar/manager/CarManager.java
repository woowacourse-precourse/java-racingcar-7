package racingcar.manager;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;

public class CarManager {
    private List<Car> carList;

    public CarManager() {
        carList = new ArrayList<>();
    }

    public void setParticipateCars(String[] cars) {
        if (!carList.isEmpty()) {
            return;
        }
        for (String carName : cars) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
