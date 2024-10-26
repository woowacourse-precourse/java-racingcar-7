package racingcar;

import java.util.List;

public class Validator {

    public void validateCarNamesInput(String inputStr) {
        if (inputStr.isEmpty()) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다");
        }
        if (inputStr.charAt(0) == ',' || inputStr.charAt(inputStr.length()) == ',') {
            throw new IllegalArgumentException("구분자는 차 이름 사이에 위치할 수 있습니다.");
        }
    }

    public void validateCarNamesLength(List<String> carNames, int standard) {
        for (String carName : carNames) {
            if (carName.length() > standard)
                throw new IllegalArgumentException("자동차 이름은 기준을 넘길 수 없습니다.");
        }
    }
}
