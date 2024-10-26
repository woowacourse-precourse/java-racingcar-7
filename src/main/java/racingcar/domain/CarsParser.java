package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsParser {

    private static final int MIN_CARS_LENGTH = 2;

    public List<Car> parse(String invalidCarNames) {
        List<String> splitCarNames = getSplitCarNames(invalidCarNames);
        validateCarNames(splitCarNames);

        return splitCarNames.stream()
            .map(Car::new)
            .toList();
    }

    private List<String> getSplitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    private void validateCarNames(List<String> splitCarNames) {
        validateCarLength(splitCarNames);
        validateNoDuplicates(splitCarNames);
    }

    private void validateCarLength(List<String> splitCarNames) {
        if (splitCarNames.size() < MIN_CARS_LENGTH) {
            throw new IllegalArgumentException("경주를 하기 위해서는 두대 이상의 자동차가 필요합니다.");
        }
    }

    private void validateNoDuplicates(List<String> splitCarNames) {
        Set<String> uniqueNames = new HashSet<>(splitCarNames);

        if (uniqueNames.size() != splitCarNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
    }
}
