package racingcar.validator;

public class RoundValidator {

    public static void notNullOrEmpty(String round) {
        if (round == null || round.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 값입니다.");
        }
    }

    public static void noDecimalPoint(String round) {
        if (round.contains(".")) {
            throw new IllegalArgumentException("입력값에 소수점이 포함될 수 없습니다.");
        }
    }

    public static void isInteger(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값이 포함되었거나 정수 범위를 초과했습니다.", e);
        }
    }

    public static void nonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("입력값은 음수가 될 수 없습니다.");
        }
    }

    public static void nonZero(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("입력값은 0이 될 수 없습니다.");
        }
    }

}
