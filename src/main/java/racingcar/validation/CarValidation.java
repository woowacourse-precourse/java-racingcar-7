package racingcar.validation;

import java.util.Set;

public class CarValidation {

    public static final String EMPTY_CAR_NAME_ERROR = "자동차 이름은 공백이 될 수 없습니다.";
    public static final String DUPLICATE_CAR_NAME_ERROR = "자동차 이름은 중복될 수 없습니다.";
    public static final String CAR_NAME_LENGTH_ERROR = "자동차 이름은 5자 이하로 입력해 주세요.";

    public static void validateCarName(String name, Set<String> carNames) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR);
        }
        if (!carNames.add(name)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }
}
