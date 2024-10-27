package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarManager {
    private static final String SPLITTER = ",";

    public List<Car> createCarsFromInput(String input) {
        List<String> carNames = Arrays.stream(input.split(SPLITTER)).toList();

        validateCount(carNames);
        validateDuplicate(carNames);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> set = new HashSet<>();
        for (String name : carNames) {
            if (!set.add(name)) {
                throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다. 중복 이름 : " + name);
            }
        }
    }

    private void validateCount(List<String> carNames) {
        if (carNames.size() < 2 || carNames.size() > 1000) {
            throw new IllegalArgumentException("자동차의 개수는 최소 2개부터 최대 1,000개까지 가능합니다.");
        }
    }

    public List<Car> findWinner(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 결과입니다."));

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }
}
