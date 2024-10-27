package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Parser {
    public static List<Car> parseCarList(String cars) {
        List<Car> carList = new ArrayList<>();

        for (String car : cars.split(",")) {
            validateCarName(car);
            carList.add(new Car(car));
        }

        return carList;
    }

    private static void validateCarName(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자 이하만 가능합니다.");
        }
    }
}
