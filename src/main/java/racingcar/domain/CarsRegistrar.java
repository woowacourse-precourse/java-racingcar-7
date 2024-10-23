package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * trim
 */
public class CarsRegistrar {

    public Cars registerCars(String input) {
        Set<Car> cars = new HashSet<>();

        for (Car car : getParsedCar(input)) {
            if (!cars.add(car)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
        }
        return new Cars(cars);
    }

    private static List<Car> getParsedCar(String carNames) {
        List<Car> result = new ArrayList<>();
        String[] splitWord = carNames.split(",");
        for (String s : splitWord) {
            result.add(new Car(s.trim()));
        }
        return result;
    }


}
