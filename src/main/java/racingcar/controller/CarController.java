package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarController {

    public static List<String> makeCarNameList(String carString) {
        List<String> carNameList = new ArrayList<>();

        String[] splitCars = carString.split(",");

        for (String splitCar : splitCars) {
            if (splitCar.strip().length() >= 1 && splitCar.strip().length() <= 5) {
                carNameList.add(splitCar.strip());
            } else {
                throw new IllegalArgumentException("자동차 이름은 1~5글자만 가능합니다.");
            }
        }

        return carNameList;
    }

    public static List<Car> makeCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNameList.size(); i++) {
            Car car = new Car();

            car.setCarName(carNameList.get(i));

            carList.add(car);
        }

        return carList;
    }
}
