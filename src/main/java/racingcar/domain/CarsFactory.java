package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsFactory {
    private final static String CAR_NAME_DELIMITER = ",";

    public Cars registerCars(String input) {
        validateEmptyCarName(input);
        Set<Car> cars = new HashSet<>();

        for (Car car : getParsedCar(input)) {
            validateDuplicateCarName(car, cars);
        }
        return new Cars(cars);
    }

    private List<Car> getParsedCar(String carNames) {
        List<Car> result = new ArrayList<>();
        String[] splitWord = carNames.split(CAR_NAME_DELIMITER);

        for (String s : splitWord) {
            result.add(new Car(s.trim()));
        }
        return result;
    }


    private void validateDuplicateCarName(Car car, Set<Car> cars) {
        if (!cars.add(car)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private static void validateEmptyCarName(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다. 최소 1대 이상 입력해주세요.");
        }
    }

}
