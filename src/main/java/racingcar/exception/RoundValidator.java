package racingcar.exception;

public class RoundValidator {

    public static int validateRound(String round) {
        try {
            int roundInt = Integer.parseInt(round);
            validateNonNegativeNumber(roundInt);
            return roundInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void validateNonNegativeNumber(int roundInt) {
        if (roundInt < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
