package racingcar.validate;

public class RacingcarAttemptValidate {
    public void isBlank(String attempt) {
        if (attempt.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수 공백");
        }
    }

    public void isParsable(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 정수 이외 데이터 입력");
        }
    }
}
