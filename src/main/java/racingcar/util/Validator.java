package racingcar.util;

public class Validator {

    // 자동차 이름 유효성 검사
    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            if (name.length() > Constants.MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            if (name.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
            }
        }
    }

    // 시도 횟수 유효성 검사
    public static void validateTryCnt(String input) {
        try {
            int tryCnt = Integer.parseInt(input);
            if (tryCnt <= 0)
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
