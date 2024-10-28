package racingcar.validator;

import racingcar.model.Car;
import java.util.List;

public class RaceValidator {

    public static void validateCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("참가하는 자동차 목록이 비어 있을 수 없습니다.");
        }
    }

    public static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }
}
