package racingcar.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private final static String EXCEPTION_MESSAGE_ONLY_COMMA = "입력한 값은, 만 있으면 안 됩니다.";
    private final static String EXCEPTION_MESSAGE_EMPTY_CAR = "자동차 이름은 비어있거나 공백이면 안 됩니다.";
    private final static String EXCEPTION_MESSAGE_LENGTH_CAR = "자동차 이름의 길이는 5자를 초과하면 안 됩니다.";
    private final static String EXCEPTION_MESSAGE_DUPLICATE_CAR_NAME = "같은 자동차의 이름을 입력하면 안 됩니다.";
    private final static int CAR_NAME_LENGTH_STANDARD = 5;

    public void validate(List<String> carNames) {
        validateEmptyList(carNames);
        validateLengthCarName(carNames);
        validateDuplicationCarName(carNames);
    }

    private void validateEmptyList(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ONLY_COMMA);
        }
    }

    private void validateLengthCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.isBlank()) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE_EMPTY_CAR);
            }
            if (carName.length() > CAR_NAME_LENGTH_STANDARD) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE_LENGTH_CAR);
            }
        }
    }

    private void validateDuplicationCarName(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : carNames) {
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATE_CAR_NAME);
            }
        }
    }

}
