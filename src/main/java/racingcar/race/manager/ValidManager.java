package racingcar.race.manager;

public class ValidManager {
    private static final String ERROR_MESSAGE_IF_IT_IS_NOT_NEGATIVE_NUMBER = "양수의 숫자를 입력해야합니다.";
    private static final int MINIMUM_ROUND_THRESHOLD = 0;

    public void validate(int round) {
        if (round <= MINIMUM_ROUND_THRESHOLD) {
            throw new IllegalArgumentException(ERROR_MESSAGE_IF_IT_IS_NOT_NEGATIVE_NUMBER);
        }
    }
}
