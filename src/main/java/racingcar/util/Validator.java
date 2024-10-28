package racingcar.util;

public class Validator {
    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 입력은 공백이 아니어야 합니다.");
        }

        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 한 글자 이상이어야 합니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
