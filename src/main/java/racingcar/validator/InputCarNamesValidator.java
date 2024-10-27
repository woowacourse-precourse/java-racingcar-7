package racingcar.validator;

import java.util.HashSet;

public class InputCarNamesValidator {
    private HashSet<String> validCarNames = new HashSet<>();

    public boolean isCarNameLengthValid(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름이 5자를 초과했습니다.");
        }
        return true;
    }

    public boolean isNotDuplicateCarName(String carName) {
        if (validCarNames.contains(carName)) {
            throw new IllegalArgumentException("자동차 이름이 중복되어 입력되었습니다.");
        }
        validCarNames.add(carName);
        return true;
    }

    public boolean isNotCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
        return true;
    }
}
