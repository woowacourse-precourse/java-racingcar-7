package racingcar.model.car;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carsNames) {
        validateDuplicateCarNames(carsNames);
        cars = carsNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateDuplicateCarNames(List<String> carNames) {
        List<String> uniqueCarNames = removeDuplicateCarNames(carNames);
        if (carNames.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException("경주할 자동차 이름은 서로 중복될 수 없어요.");
        }
    }

    private List<String> removeDuplicateCarNames(List<String> carNames) {
        return carNames.stream()
                .distinct()
                .toList();
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
