package racingcar.validator;

import static racingcar.config.GameConstant.CAR_NAME_UPPER_BOUND;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    public static final String DUPLICATE_CAR_NAME_MESSAGE = "같은 이름을 가진 자동차가 있습니다.";
    public static final String EMPTY_NAME_MESSAGE = "이름을 1글자 이상 입력해주세요.";
    public static final String LENGTH_EXCEED_MESSAGE = "허용된 이름 길이를 초과했습니다.";
    public static final String INVALID_NAME_FORMAT_MESSAGE = "이름은 공백으로 시작하거나 끝낼 수 없습니다.";
    private CarNameValidator() {
        throw new IllegalStateException("Validator Class");
    }

    public static void validateCarName(String[] carNames) {
        validateEmptyName(carNames);
        validateDuplicateCarName(carNames);
        validateNameFormat(carNames);
        validateAllowedLength(carNames);
    }

    private static void validateEmptyName(String[] carNames) {
        for (String carName : carNames) {
            String deleteWhiteSpaceString = carName.replace(" ", "");
            if (deleteWhiteSpaceString.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
            }
        }
    }

    private static void validateDuplicateCarName(String[] carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
            }
            carNameSet.add(carName);
        }
    }

    private static void validateNameFormat(String[] carNames) {
        for (String carName : carNames) {
            if (carName.startsWith(" ") || carName.endsWith(" ")) {
                throw new IllegalArgumentException(INVALID_NAME_FORMAT_MESSAGE);
            }
        }
    }

    private static void validateAllowedLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_UPPER_BOUND) {
                throw new IllegalArgumentException(LENGTH_EXCEED_MESSAGE);
            }
        }
    }
}
