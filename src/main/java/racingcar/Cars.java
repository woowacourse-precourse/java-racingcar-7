package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String namesInput) {
        this.cars = parseCarNames(namesInput);
    }

    private List<Car> parseCarNames(String input) {
        validateInput(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Car::new)//
                .collect(Collectors.toList());
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    public static void moveAll() {
        cars.forEach(Car::tryMove);
    }

    public static void printStatus() {
        cars.forEach(Car::printStatus);
    }
}
