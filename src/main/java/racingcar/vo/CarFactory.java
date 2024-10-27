package racingcar.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private static final String DUPLICATE_CAR_NAME = "자동차 이름이 중복되었습니다.";

    public List<Car> createCars(String[] carNames) {
        validateDuplicateCarNames(carNames);
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateDuplicateCarNames(String[] carNames) {
        long uniqueCount = Arrays.stream(carNames)
                .distinct()
                .count();
        if (uniqueCount < carNames.length) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }
}
