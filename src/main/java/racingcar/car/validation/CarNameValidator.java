package racingcar.car.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.car.exception.CarNameException;
import racingcar.common.ExceptionEnum;

public class CarNameValidator {
    private static final String REGEX = "^[a-zA-Z]+$";
    private static final int MIN_CAR_NAME_LENGTH = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    // 자동차 이름 리스트를 검증
    public void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new CarNameException(ExceptionEnum.EMPTY_CAR_NAME_LIST.getMessage());
        }

        Set<String> uniqueNames = new HashSet<>();
        for (String carName : carNames) {
            validateCarName(carName);

            // 중복 검사
            if (!uniqueNames.add(carName)) {
                throw new CarNameException(ExceptionEnum.DUPLICATE_CAR_NAME.getMessage() + carName);
            }
        }
    }

    // 개별 자동차 이름을 검증
    private void validateCarName(String carName) {
        if (carName == null) {
            throw new CarNameException(ExceptionEnum.NULL_CAR_NAME.getMessage());
        }

        carName = carName.trim();
        if (carName.isEmpty()) {
            throw new CarNameException(ExceptionEnum.EMPTY_CAR_NAME.getMessage());
        }

        if (carName.length() < MIN_CAR_NAME_LENGTH) {
            throw new CarNameException(ExceptionEnum.INVALID_MIN_CAR_NAME_LENGTH.getMessage());
        }

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameException(ExceptionEnum.INVALID_MAX_CAR_NAME_LENGTH.getMessage());
        }

        if (!Pattern.matches(REGEX, carName)) {
            throw new CarNameException(ExceptionEnum.INVALID_CAR_NAME_FORMAT.getMessage());
        }
    }
}
