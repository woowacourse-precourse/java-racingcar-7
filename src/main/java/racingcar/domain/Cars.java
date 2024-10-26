package racingcar.domain;

import java.util.*;

import static racingcar.exception.ExceptionMessage.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validNameSize(carNames);
        this.cars = createCar(carNames);
    }

    private List<Car> createCar(List<String> carNames) {
        List<Car> result = carNames.stream()
                .map(Car::new)
                .toList();

        validDuplicateName(result);

        return result;
    }

    private void validNameSize(List<String> carNames) {
        if (carNames.size() > NumberConstant.CAR_REG_MAX) {
            throw new IllegalArgumentException(CAR_LIMIT_EXCEEDED);
        }
    }

    private static void validDuplicateName(List<Car> result) {
        Set<Car> carHashSet = new HashSet<>(result);
        if (result.size() != carHashSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
