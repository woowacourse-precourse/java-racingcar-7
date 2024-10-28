package racingcar.validator;

import racingcar.exception.CarNameException;

public class CarNameValidator {
    private static final String COMMA_DELIMITER = ",";
    public static final String CAR_NAME_EMPTY_ERROR = "자동차 이름을 입력해주세요.";
    public static final String CAR_NAME_DELIMITER_ERROR = "자동차 이름은 쉼표(,)를 기준으로 구분하여야합니다.";
    public static final String CAR_NAME_LENGTH_ERROR = "각 자동차 이름은 1자 이상 5자 이하로 입력해주어야합니다.";

    public static void validate(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new CarNameException(CAR_NAME_EMPTY_ERROR);
        }

        if (!carNames.contains(COMMA_DELIMITER)) {
            throw new CarNameException(CAR_NAME_DELIMITER_ERROR);
        }

        String[] names = carNames.split(COMMA_DELIMITER);
        for (String name : names) {
            checkNameLength(name.trim());
        }
    }

    private static void checkNameLength(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new CarNameException(CAR_NAME_LENGTH_ERROR);
        }
    }
}
