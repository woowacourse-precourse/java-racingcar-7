package racingcar;

public class Validator {
    public static void validateCarNames(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("적어도 한 대의 자동차 이름을 입력해야 합니다.");
        }
        for (String name : names) {
            name = name.trim();

            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }
}
