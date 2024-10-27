package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateUniqueCarNames(cars);
        this.cars = cars;
    }

    public static Cars from(String[] carNames) {
        return new Cars(
                Arrays.stream(carNames)
                      .map(Car::from)
                      .toList()
        );
    }

    public int getMaxAdvanceMarkerCount() {
        return cars.stream()
                   .map(Car::getAdvanceMarkerCount)
                   .max(Long::compare)
                   .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void validateUniqueCarNames(List<Car> cars) {
        Set<String> uniqueNames = new HashSet<>();

        for (Car car : cars) {
            String carName = car.getName();
            if (!uniqueNames.add(carName)) {
                throw new IllegalArgumentException("이름은 중복될 수 없습니다. 중복된 이름 : " + carName);
            }
        }
    }
}
