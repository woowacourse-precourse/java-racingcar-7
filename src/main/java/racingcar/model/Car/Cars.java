package racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<Car> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        addCarName(carNames);
    }

    private void addCarName(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public static List<Car> getCarList() {
        return carList;
    }
}
