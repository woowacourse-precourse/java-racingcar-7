package racingcar.validator.strategies.carnames;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class NotNullOrEmptyValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String carNames) {
        checkNotNullOrEmpty(carNames);
        validateCarNames(carNames);
    }

    private void checkNotNullOrEmpty(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

    private void validateCarNames(String carNames) {
        // 쉼표로 구분된 자동차 이름을 List로 변환
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();

        for (String carName : carNameList) {
            checkForEmptyName(carName);
        }
    }

    private void checkForEmptyName(String carName) {
        if (isBlank(carName)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

    private boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

}
