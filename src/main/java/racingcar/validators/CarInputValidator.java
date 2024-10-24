package racingcar.validators;

import java.util.Arrays;
import java.util.List;

public class CarInputValidator implements Validator {
    private static final String COUNT_BELOW_MIN_ERROR = "자동차 이름이 2개 이상 필요합니다.";
    private static final String COUNT_EXCEEDS_MAX_ERROR = "자동차 이름은 10개까지 입력 가능합니다.";
    private static final String DUPLICATE_NAME_ERROR = "자동차 이름은 중복될 수 없습니다.";
    private static final String NAME_LENGTH_ERROR = "자동차 이름은 공백 포함 5자 이하여야 합니다.";

    @Override
    public void validate(String input) {
        List<String> cars = Arrays.asList(input.split(","));
        checkCarCount(cars);
        checkNameValidity(cars);
    }

    private void checkCarCount(List<String> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException(COUNT_BELOW_MIN_ERROR);
        }
        if (cars.size() > 10) {
            throw new IllegalArgumentException(COUNT_EXCEEDS_MAX_ERROR);
        }
    }

    private void checkNameValidity(List<String> names) {
        for (String name : names) {
            if (name.strip().length() > 5) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
            }
            if (names.indexOf(name) != names.lastIndexOf(name)) {
                throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
            }
        }
    }
}
