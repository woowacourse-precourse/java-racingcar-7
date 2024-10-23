package racingcar.vo;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CarFactory {

    public Set<Car> createCars(String[] carNames) {
        validateDuplicateCarNames(carNames);
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toSet());
    }

    private void validateDuplicateCarNames(String[] carNames) {
        Set<String> nameSet = new HashSet<>(Arrays.asList(carNames));
        if (nameSet.size() != carNames.length) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }
}
