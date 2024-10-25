package racingcar;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
 * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
 */
public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private String delimitedCarNames;
    private final List<String> carNames = new ArrayList<>();

    public List<String> validateDelimitedCarNames(String delimitedCarNames) {
        this.delimitedCarNames = delimitedCarNames;

        validateCarNamesNull();
        validateCarNamesFormat();
        validateCarNameFormat();

        return carNames;
    }

    private void validateCarNamesNull() {
        if (delimitedCarNames == null) {
            throw new IllegalArgumentException("자동차 이름 입력 형식이 null 입니다");
        }
    }

    private void validateCarNamesFormat() {
        int delimitedCarNamesLength = delimitedCarNames.length();
        if (delimitedCarNames.startsWith(",")
                || delimitedCarNames.isEmpty()
                || isEndWithComma(delimitedCarNamesLength)) {
            throw new IllegalArgumentException("올바른 자동차 이름 형식이 아닙니다");
        }
    }

    private boolean isEndWithComma(int delimitedCarNamesLength) {
        return delimitedCarNames.charAt(delimitedCarNamesLength - 1) == ',';
    }

    private void validateCarNameFormat() {
        for (String carName : delimitedCarNames.split(",")) {
            validateCarName(carName);
            carNames.add(carName);
        }
    }

    private void validateCarName(String carName) {
        validateCarNameMaxLength(carName);
        validateCarNameDuplicate(carName);
        validateCarNameEmpty(carName);
    }

    private void validateCarNameMaxLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다");
        }
    }

    private void validateCarNameDuplicate(String carName) {
        if (carNames.contains(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다");
        }
    }

    private void validateCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다");
        }
    }
}
