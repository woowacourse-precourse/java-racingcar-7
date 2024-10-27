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

        validateCarNum(carList);

        return carList;
    }

    private static void validateCarName(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자 이하만 가능합니다.");
        }
    }

    private static void validateCarNum(List<Car> carList) {
        if (carList.size() <= 1) {
            throw new IllegalArgumentException("경주를 하기 위해서 2대 이상의 자동차 입력이 필요합니다.");
        }
    }
}
