package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator {

    // 첫 번째 기능: 자동차 이름 입력 및 검증
    public static List<String> getCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        carNames.forEach(CarNameValidator::validateCarName);
        return carNames;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
