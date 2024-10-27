package racingcar.validator;

import racingcar.common.Symbol;

import java.util.List;

public class InputValidator {

    public static final String CAR_NAME_PATTERN = "^[가-힣a-zA-Z,]+$";
    public static final String LOOP_COUNT_PATTERN = "[1-9]\\d*";
    public static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateCarName(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("이름이 없는 자동차는 존재할 수 없습니다.");
            }
            if (carName.contains(Symbol.SPACE)) {
                throw new IllegalArgumentException("자동차 이름엔 공백을 포함할 수 없습니다.");
            }
            if (!carName.matches(CAR_NAME_PATTERN)) {
                throw new IllegalArgumentException("자동차 이름은 한글 또는 영문으로만 가능하며 , 를 제외한 특수문자는 사용할 수 없습니다.");
            }
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름의 길이는 최대 5글자 입니다.");
            }
        }
    }

    public void validateLoopCount(String inputLoopCount) {
        if (inputLoopCount.isEmpty()) {
            throw new IllegalArgumentException("반복할 횟수는 필수 입력 값 입니다.");
        }
        if (!inputLoopCount.matches(LOOP_COUNT_PATTERN)) {
            throw new IllegalArgumentException("반복할 횟수는 1 이상의 정수로만 입력 가능합니다.");
        }
    }
}
