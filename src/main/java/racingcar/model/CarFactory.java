package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarFactory {
    public List<Car> createCars(String names) {
        validateInput(names);
        List<String> carNames = Arrays.stream(names.split(","))
                .map(String::trim)
                .toList();

        validateUniqueNames(carNames);

        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateInput(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 입력이 잘못되었습니다.");
        }
    }

    private void validateUniqueNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
