package racingcar.domain;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validNameSize(carNames);
        this.cars = createCar(carNames);
    }

    private List<Car> createCar(List<String> carNames) {
        List<Car> result =  carNames.stream()
                .map(Car::new)
                .toList();

        validDuplicateName(result);

        return result;
    }

    private void validNameSize(List<String> carNames) {
        if (carNames.size() > NumberConstant.CAR_REG_MAX) {
            throw new IllegalArgumentException("자동차는 100대까지 등록 가능합니다.");
        }
    }

    private static void validDuplicateName(List<Car> result) {
        Set<Car> carHashSet = new HashSet<>(result);
        if (result.size() != carHashSet.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다.");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
