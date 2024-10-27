package racingcar.manager;

import static racingcar.util.RandomNumberGenerator.generateRandomNumber;

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

    public void moveCars() {
        for (Car car : carList) {
            car.moveCar(generateRandomNumber());
        }
    }
}
