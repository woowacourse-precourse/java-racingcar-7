package racingcar;

public class AttemptValidator {
    public static int validatePositiveInt(String attemptsInput) {
        try {
            int attemptsNum = Integer.parseInt(attemptsInput);
            if (attemptsNum <= 0) {
                throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
            }
            return attemptsNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }
}
