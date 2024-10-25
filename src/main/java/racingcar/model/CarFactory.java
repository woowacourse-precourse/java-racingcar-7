package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public List<Car> createCars(String names) {
        validateInput(names);

        return Arrays.stream(names.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
    private static void validateInput(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 입력이 잘못되었습니다.");
        }
    }
}
