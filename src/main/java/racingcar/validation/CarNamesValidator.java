package racingcar.validation;

import java.util.Arrays;
import java.util.List;

public class CarNamesValidator implements Validator {

    @Override
    public void validate(String carNames) {
        validateNotBlank(carNames);
        parseCarNames(carNames)
            .forEach(this::validateNameLength);
    }

    private void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력해주세요.");
        }
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || 5 < name.length()) {
            throw new IllegalArgumentException("이름은 공백일 수 없고, 5자 이하만 가능합니다.");
        }
    }
}
