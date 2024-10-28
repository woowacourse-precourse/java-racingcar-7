package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    Cars cars;

    public Race(String carNames) {
        List<Car> carList = getCarList(carNames);

        this.cars = new Cars(carList);
    }

    private static List<Car> getCarList(String carNames) {
        String[] carNameList = carNames.split(",");
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }

        return carList;
    }
}
