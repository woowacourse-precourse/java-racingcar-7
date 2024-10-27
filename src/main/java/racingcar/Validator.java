package racingcar;

import java.util.List;

public class Validator {
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "%s은(는) 비어있을 수 없습니다.";
    public static final String ILLEGAL_OPERATOR_MESSAGE = "구분자는 차 이름 사이에 위치할 수 있습니다.";
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 기준을 넘길 수 없습니다.";
    public static final String REPEAT_COUNT_RANGE_ERROR = "양수만 입력 가능합니다.";
    public static final String INVALID_INPUT_COUNT_NUMBER = "숫자만 입력 가능합니다.";

    public void validateCarNamesInput(String inputStr) {
        if (inputStr.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.formatted("입력"));
        }
        if (inputStr.charAt(0) == ',' || inputStr.charAt(inputStr.length() - 1) == ',') {
            throw new IllegalArgumentException(ILLEGAL_OPERATOR_MESSAGE);
        }
    }

    public void validateCarNamesLength(List<String> carNames, int nameLengthLimits) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.formatted("자동차 이름"));
            }

            if (carName.length() > nameLengthLimits) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    public void validateRepeatCount(String inputStr) {
        if (inputStr.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.formatted("반복 횟수"));
        }
        try {
            long num = Long.parseLong(inputStr);
            if (num <= 0) {
                throw new IllegalArgumentException(REPEAT_COUNT_RANGE_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_COUNT_NUMBER);
        }
    }
}
