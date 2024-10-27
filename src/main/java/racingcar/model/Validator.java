package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_CAR_POSITION = 4;

    protected void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다. 빈 문자열이 아닌 이름을 입력해주세요.");
        }
        if (name.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("잘못된 입력입니다. 이름을 5자 이하로 입력해주세요.");
        }
    }

    protected boolean validatePosition(int position) {
        boolean isValidPosition = false;

        if (position >= MIN_CAR_POSITION) {
            isValidPosition = true;
        }
        return isValidPosition;
    }

    protected List<String> refineString(String carNames) {
        String[] splitCarNames = carNames.split(",");
        List<String> carNamesList = Arrays.asList(splitCarNames);

        return carNamesList;
    }
}