package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarService {

    public Car createCar(String name) {
        return new Car(name);
    }

    public List<Car> splitCar(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(createCar(carName.trim()));
        }
        return carList;
    }


}
