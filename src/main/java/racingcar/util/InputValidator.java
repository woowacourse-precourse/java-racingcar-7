package racingcar.util;

import racingcar.domain.Car;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_CARS = 2;
    private static final int MAX_CARS = 100;
    private static final int MAX_ATTEMPTS = 100;
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9가-힣]+$");
    private static final int MAX_INPUT_LENGTH = 1000;

    private InputValidator() {
    }

    public static void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        if (input.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력이 너무 깁니다.");
        }
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 %d자 이하만 가능합니다: %s", MAX_NAME_LENGTH, name)
            );
        }
        if (!VALID_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(
                    "자동차 이름은 한글, 영문, 숫자만 가능합니다: " + name
            );
        }
    }

    public static void validateCars(List<Car> cars) {
        validateCarCount(cars);
        validateDuplicateNames(cars);
    }

    private static void validateCarCount(List<Car> cars) {
        if (cars.size() < MIN_CARS) {
            throw new IllegalArgumentException("최소 " + MIN_CARS + "대의 자동차가 필요합니다.");
        }
        if (cars.size() > MAX_CARS) {
            throw new IllegalArgumentException("최대 " + MAX_CARS + "대까지만 가능합니다.");
        }
    }

    private static void validateDuplicateNames(List<Car> cars) {
        Set<String> uniqueNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public static int validateAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input.trim());
            validateAttemptsRange(attempts);
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateAttemptsRange(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
        if (attempts > MAX_ATTEMPTS) {
            throw new IllegalArgumentException("시도 횟수는 최대 " + MAX_ATTEMPTS + "회까지만 가능합니다.");
        }
    }
}