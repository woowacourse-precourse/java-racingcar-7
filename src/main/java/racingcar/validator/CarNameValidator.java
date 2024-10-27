package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.CarRacingException;
import racingcar.exception.ErrorMessage;

/**
 * CarNameValidator
 * - 자동차 이름 유효성 검사
 */
public class CarNameValidator {

    public static void validateNames(List<String> carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            validate(name);
            if (!nameSet.add(name)) {
                throw new CarRacingException(ErrorMessage.DUPLICATE_CAR_NAME);
            }
        }
    }

    public static void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new CarRacingException(ErrorMessage.EMPTY_CAR_NAME);
        }

        if (name.length() > 5) {
            throw new CarRacingException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }

        if (name.contains(" ")) {
            throw new CarRacingException(ErrorMessage.INVALID_CAR_NAME_SPACE);
        }
    }
}
