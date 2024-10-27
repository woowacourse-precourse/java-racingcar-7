package racingcar.service;

import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;


public class RaceService {

    public List<Car> makeCarList (String[] carNamesList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNamesList) {
            carList.add(new Car(carName));
        }
        return carList;
    }
}
