package racingcar.validator;

import java.util.List;

public class Validator {

    private Validator() {
    }

    public static void validateCarNames(List<String> carNames) {
        carNames.forEach(name -> {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 다섯 글자 이하로 입력하세요.");
            }
        });
    }
}
