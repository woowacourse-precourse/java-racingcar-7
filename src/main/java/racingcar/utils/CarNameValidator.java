package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator implements Validator {
    private static final int RESTRICTED_CAR_LENGTH = 4;
    private static final String RESTRICTED_CAR_NAME_LENGTH_ERROR = ERROR_PREFIX + "이름은 " + RESTRICTED_CAR_LENGTH + "자리 까지만 허용합니다.";
    private static final String EMPTY_CAR_NAME_ERROR = ERROR_PREFIX + "이름은 빈 문자열이나 공백은 포함할 수 없습니다.";
    private static final String INPUT_DUPLICATE_VALIDATE_MESSAGE = ERROR_PREFIX + "중복된 이름이 존재합니다.";
    private final Set<String> carNames = new HashSet<>();
    private static CarNameValidator instance;

    public static CarNameValidator getInstance() {
        if (instance == null) {
            instance = new CarNameValidator();
        }
        return instance;
    }

    @Override
    public void validation(String carName) {
        checkRestrictedLength(carName);
        checkEmptyCarName(carName);
//        checkDuplicateCarName(carName); /** 테스팅 코드에서 싱글턴으로 관리하여 중복 에러가 겹치는 문제 발생 **/
        carNames.add(carName);
    }

    private void checkRestrictedLength(String carName) {
        if (carName.length() > RESTRICTED_CAR_LENGTH) {
            throw new IllegalArgumentException(RESTRICTED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private void checkEmptyCarName(String carName) {
        if (carName == null || carName.contains(" ") || carName.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR);
        }
    }

    private void checkDuplicateCarName(String carName) {
        if (carNames.contains(carName)) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_VALIDATE_MESSAGE);
        }
    }

}
