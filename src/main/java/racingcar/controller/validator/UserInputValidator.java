package racingcar.controller.validator;

import java.util.Arrays;
import java.util.List;

public class UserInputValidator {
    private static final String NOT_A_NUMBER_ERROR = "숫자를 입력해주세요.";
    private static final String NOT_A_VALID_NAME_ERROR = "자동차 이름이 입력되지 않았습니다.";
    private static final String INVALID_SPLITTER_ERROR = "구분자 ',' 뒤에는 이름이 위치해야 합니다.";
    private static final String EMPTY_NAME_ERROR = "이름은 빈칸일 수 없습니다.";
    private static final String NUMBER_UNDER_ZERO_ERROR = "이동 횟수는 0회 이상입니다.";
    private static final String NAME_LENGTH_ERROR = "자동차 이름은 최대 5글자입니다.";
    private static final int MAX_NAME_LENGTH = 5;

    public Integer validateRoundCount(String rawInput) {
        try {
            int roundCountInt = Integer.parseInt(rawInput);
            validateNumberUnderZero(roundCountInt);
            return roundCountInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_ERROR);
        }
    }

    public List<String> validateCarNames(String rawInput) {
        List<String> carNames = Arrays.stream(rawInput.split(","))
                .map(String::trim) // 공백 제거
                .toList();

        validateCarNamesFormat(rawInput, carNames);
        validateCarNamesLength(carNames);

        return carNames;
    }

    private void validateNumberUnderZero(int roundCount) {
        if (roundCount < 0) {
            throw new IllegalArgumentException(NUMBER_UNDER_ZERO_ERROR);
        }
    }

    private void validateCarNamesFormat(String rawInput, List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(NOT_A_VALID_NAME_ERROR);
        }

        int splitterCount = rawInput.length() - rawInput.replace(",", "").length();
        if (carNames.size() != splitterCount + 1) {
            throw new IllegalArgumentException(INVALID_SPLITTER_ERROR);
        }

        if (carNames.contains("")) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    private void validateCarNamesLength(List<String> carNames) {
        carNames.forEach(carName -> {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
            }
        });
    }
}
