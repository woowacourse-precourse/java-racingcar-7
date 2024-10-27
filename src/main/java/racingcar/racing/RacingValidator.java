package racingcar.racing;

public class RacingValidator {

    public static void tryCountParseInteger(String tryNumber) {
        try {
            Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효 하지 않은 시도할 횟수 입니다.");
        }
    }

    public static void tryCountEmpty(String tryNumber) {
        if (tryNumber.isBlank()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해 주세요.");
        }
    }
}
