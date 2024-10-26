package racingcar.domain;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.generator.NumberGenerator;

public class RaceRule {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int THRESHOLD = 4;
    private final NumberGenerator numberGenerator;

    public RaceRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canMove() {
        int generated = numberGenerator.generate();
        validateGeneratedNumber(generated);
        return generated >= THRESHOLD;
    }

    public static List<Car> determineWinners(List<Car> cars) {
        validateCars(cars);

        return findWinners(cars);
    }

    private void validateGeneratedNumber(int number) {
        if (MIN_NUMBER <= number && number <= MAX_NUMBER) {
            return;
        }

        throw new IllegalArgumentException(
                String.format("생성된 숫자는 %d에서 %d 사이여야 합니다.", MIN_NUMBER, MAX_NUMBER)
        );
    }

    private static void validateCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 목록은 비었을 수 없습니다.");
        }


    }

    private static List<Car> findWinners(List<Car> cars) {
        int maxMovement = getMaxMovement(cars);
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .toList();
    }

    private static int getMaxMovement(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElse(0);
    }
}