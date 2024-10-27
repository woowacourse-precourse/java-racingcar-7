package racingcar.domain;

import java.util.HashSet;
import java.util.List;

import racingcar.utils.generator.NumberGenerator;

public class RaceRule {
    private static final int MIN_NAMES_SIZE = 2;
    private static final int MAX_NAMES_SIZE = 10;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int THRESHOLD = 4;
    private final NumberGenerator numberGenerator;

    public RaceRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    // 이동 규칙
    public boolean canMove() {
        int generated = numberGenerator.generate();
        validateGeneratedNumber(generated);
        return generated >= THRESHOLD;
    }

    // 우승자 규칙
    public static List<Car> findWinners(List<Car> cars) {
        int maxMovement = getMaxMovement(cars);
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .toList();
    }

    // 이름 규칙
    public static void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 목록은 비었을 수 없습니다.");
        }
        if (isDuplicatedNames(names)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        if (MIN_NAMES_SIZE > names.size() || names.size() > MAX_NAMES_SIZE) {
            String message = String.format("참가하는 자동차는 %d에서 %d 사이여야 합니다.", MIN_NAMES_SIZE, MAX_NAMES_SIZE);
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateGeneratedNumber(int number) {
        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            String message = String.format("생성된 숫자는 %d에서 %d 사이여야 합니다.", MIN_NUMBER, MAX_NUMBER);

            throw new IllegalArgumentException(message);
        }
    }

    private static int getMaxMovement(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElse(0);
    }

    private static boolean isDuplicatedNames(List<String> names) {
        return names.size() != new HashSet<>(names.stream().toList()).size();
    }
}