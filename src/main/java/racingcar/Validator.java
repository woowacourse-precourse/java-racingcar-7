package racingcar;

import java.util.List;

public class Validator {

    public void validateCarNamesInput(String inputStr) {
        if (inputStr.isEmpty()) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다");
        }
        if (inputStr.charAt(0) == ',' || inputStr.charAt(inputStr.length() - 1) == ',') {
            throw new IllegalArgumentException("구분자는 차 이름 사이에 위치할 수 있습니다.");
        }
    }

    public void validateCarNamesLength(List<String> carNames, int nameLengthLimits) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어있지 않습니다.");
            }

            if (carName.length() > nameLengthLimits) {
                throw new IllegalArgumentException("자동차 이름은 기준을 넘길 수 없습니다.");
            }
        }
    }

    public void isPositiveNumber(String inputStr) {
        try {
            long num = Long.parseLong(inputStr);
            if (num < 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }
}
